package com.sungjin.jobfair.controller.user;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sungjin.jobfair.pagination.EmpPageGate;
import com.sungjin.jobfair.pagination.empSrc.EmpSrcPageGate;
import com.sungjin.jobfair.pagination.PageGate;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.empSrc.EmpSrcCriteria;
import com.sungjin.jobfair.pagination.empSrc.EmpSrcPageVO;
import com.sungjin.jobfair.pagination.PageVO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/jobfair")
public class UserController {

    //인터페이스 타입 선언
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;


        //이력서 목록가져오기
    @PostMapping(value = "/resumeInfo")
    public ArrayList<ResumeVO> resumeInfo(@RequestBody UserVO vo) {

        String user_id = vo.getUser_id();
        ArrayList<ResumeVO> list = userService.resumeInfo(user_id);

        return list;
    }

        //이력서 삭제하기
    @PostMapping(value = "/deleteResume")
    public void deleteResume(@RequestBody ResumeVO vo) {
        //DB에 저장된 데이터 삭제
        String res_num = String.valueOf(vo.getRes_num());
        userService.deleteEdu(res_num);
        userService.deleteWe(res_num);
        userService.deleteCert(res_num);
        userService.deleteResume(res_num);

        //S3에 저장된 이미지 삭제 (없으면 진행x)
        if(vo.getRes_picName().length() > 0){
            String fileName = vo.getRes_picUuid() + "_" + vo.getRes_picName();
            String bucket = vo.getRes_picPath();

            amazonS3Client.deleteObject(new DeleteObjectRequest(bucket + "/image", bucket + "/image/" + fileName));

        }

    }
        //이력서 등록
    @PostMapping(value = "/regResume",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String regResume(@RequestPart("res_img") MultipartFile file,
                            @RequestPart("resData") ObjectNode node) throws IOException {

        ResumeVO resumeVO = new ResumeVO();
        ArrayList<EduVO> eduList = new ArrayList<>();
        ArrayList<WeVO> weList = new ArrayList<>();
        ArrayList<CertVO> certList = new ArrayList<>();

        //AWS S3 파일 업로드
        String pic_name = file.getOriginalFilename();
        File uploadFile = new File(pic_name); //파일 이름
        FileOutputStream fos = new FileOutputStream(uploadFile);
        String pic_uuid = UUID.randomUUID().toString(); //uuid
        String fileName = pic_uuid + "_" + pic_name; //uuid + 파일이름
        String pic_path = bucket + "/image";
        fos.write(file.getBytes());
        fos.close();

        amazonS3Client.putObject(new PutObjectRequest(pic_path, fileName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));

        ObjectMapper mapper = new ObjectMapper();

        try {
            resumeVO = mapper.treeToValue(node.get("resInfo"), ResumeVO.class);
            resumeVO.setRes_picName(pic_name);
            resumeVO.setRes_picPath(pic_path);
            resumeVO.setRes_picUuid(pic_uuid);
            eduList = mapper.convertValue((node.get("eduInfo")), new TypeReference<ArrayList<EduVO>>(){});
            weList = mapper.convertValue((node.get("weInfo")), new TypeReference<ArrayList<WeVO>>(){});
            certList = mapper.convertValue((node.get("certInfo")), new TypeReference<ArrayList<CertVO>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        //인적사항 insert
        userService.regResume(resumeVO);
        int res_num = resumeVO.getRes_num();

        for (EduVO edu : eduList) {
            edu.setRes_num(res_num);
            userService.regResEdu(edu);
        }
        for (WeVO we : weList) {
            we.setRes_num(res_num);
            userService.regResWe(we);
        }
        for (CertVO cert : certList) {
            cert.setRes_num(res_num);
            userService.regResCert(cert);
        }

        return "success";
    }


        //이력서 상세페이지
    @GetMapping("/getResumeDetail")
    public Map getResumeDetail(@RequestParam("res_num") String res_num) {
        Map<String, Object> map = new HashMap<>();

        ResumeVO resVO =  userService.getResDetail(res_num);
        ArrayList<EduVO> eduList = userService.getEduDetail(res_num);
        ArrayList<WeVO> weList = userService.getWeDetail(res_num);
        ArrayList<CertVO> certList = userService.getCertDetail(res_num);

        String path = resVO.getRes_picUuid() + "_" + resVO.getRes_picName();
        String bucket = resVO.getRes_picPath();

        String url = amazonS3Client.getUrl(bucket, path).toString();

        map.put("resVO", resVO);
        map.put("eduList", eduList);
        map.put("weList", weList);
        map.put("certList", certList);
        map.put("imageUrl", url);

        return map;
    }
        //이력서 수정(update)
    @PostMapping(value = "/modiResume",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String modiResume(@RequestPart("res_img") MultipartFile file,
                            @RequestPart("resData") ObjectNode node) throws Exception {

        ResumeVO resumeVO = new ResumeVO();
        ArrayList<EduVO> eduList = new ArrayList<>();
        ArrayList<WeVO> weList = new ArrayList<>();
        ArrayList<CertVO> certList = new ArrayList<>();

        //AWS S3 파일 업로드
        String pic_name = file.getOriginalFilename();
        File uploadFile = new File(pic_name); //파일 이름
        FileOutputStream fos = new FileOutputStream(uploadFile);
        String pic_uuid = UUID.randomUUID().toString(); //uuid
        String fileName = pic_uuid + "_" + pic_name; //uuid + 파일이름
        String pic_path = bucket + "/image";
        fos.write(file.getBytes());
        fos.close();

        amazonS3Client.putObject(new PutObjectRequest(pic_path, fileName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));

        ObjectMapper mapper = new ObjectMapper();
        try {
            resumeVO = mapper.treeToValue(node.get("resInfo"), ResumeVO.class);
            resumeVO.setRes_picName(pic_name);
            resumeVO.setRes_picPath(pic_path);
            resumeVO.setRes_picUuid(pic_uuid);
            eduList = mapper.convertValue((node.get("eduInfo")), new TypeReference<ArrayList<EduVO>>(){});
            weList = mapper.convertValue((node.get("weInfo")), new TypeReference<ArrayList<WeVO>>(){});
            certList = mapper.convertValue((node.get("certInfo")), new TypeReference<ArrayList<CertVO>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        //인적사항 update
        userService.modiResume(resumeVO);

        for (EduVO edu : eduList) {
            userService.modiResEdu(edu);
        }
        for (WeVO we : weList) {
            userService.modiResWe(we);
        }
        for (CertVO cert : certList) {
            userService.modiResCert(cert);
        }

        return "success";
    }


    //**********************************************큐앤에이 **********************************************
        //큐앤에이 등록
    @PostMapping(value = "/qnaRegist")
    public String qnaRegist(@RequestBody QnAVO vo) {
        userService.qnaRegist(vo);
        return "success";
    }
        //큐앤에이 목록
    @PostMapping(value = "/getQnAList")
    public ArrayList<QnAVO> getQnAList(Criteria cri) {

        ArrayList<QnAVO> list = userService.getQnAList(cri);

        return list;
    }
        //큐앤에이 상세페이지 데이터 불러오기
    @GetMapping(value = "/getQnADetail")
    public QnAVO getQnADetail(@RequestParam("qa_num") int qa_num) {

        QnAVO vo = userService.getQnADetail(qa_num);

        return vo;
    }
        //큐앤에이 수정
    @PostMapping ( "/uQnAModi")
    public int uQnAModi(@RequestBody QnAVO vo) {
        int a = userService.uQnAModi(vo);

        return a;
    }


    //메인페이지에서 큐앤에이 리스트 가져오기
    @PostMapping(value = "/getMainQnAList")
    public ArrayList<QnAVO> getMainQnAList() {

        ArrayList<QnAVO> list = userService.getMainQnAList();

        return list;
    }


    //**********************************************채용공고**********************************************

    //채용공고 목록
    @GetMapping(value = "/getJobPostList")
    public Map getJobPostList(Criteria cri) {

        //위에서 지정해준 조건에 따른 참여 기업 목록의 total 값 가져오기
        int total = userService.getJobPostTotal(cri);

        //해당 유저가 지원한 공고 jpl_num 가져오기
        String user_id = cri.getUser_id();
        ArrayList<EmpApplyVO> appliedList = userService.appliedList(user_id);

        //위에서 지정해준 조건에 따른 참여 기업 목록 (1페이지당 몇개) 가져오기
        ArrayList<EmpListVO> list = userService.getJobPostList(cri);

        List<String> urlList = new ArrayList<>();
        for(EmpListVO vo : list){
            String path = vo.getJpl_fileUuid() + "_" + vo.getJpl_fileName();
            String bucket = vo.getJpl_filePath();
            String url = amazonS3Client.getUrl(bucket, path).toString();
            urlList.add(url);
        }

        //pageVO 생성
        PageVO pageVO = new PageVO(cri, total);
//        System.out.println(pageVO);

        //list 와 pageVO 를 담아줄 PageGate 생성, 그리고 객체들 담기
        EmpPageGate empPageGate = new EmpPageGate(list, pageVO);
//        System.out.println(empPageGate);

        Map map = new HashMap();
        map.put("urlList", urlList);
        map.put("empPageGate", empPageGate);
        map.put("appliedList", appliedList);

        return map;
    }

    //채용공고 목록 갯수 (#### 페이지 네이션 ####)
    @GetMapping(value = "/getJobPostTotal")
    public int getJobPostTotal(Criteria cri) {
        int total = userService.getJobPostTotal(cri);
        return total;
    }
        @RequestMapping(value="/getJobPostSrc",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
        public Map getJobPostSrc(@RequestBody EmpSrcCriteria cri) {
            cri.setPage(1);
            //위에서 지정해준 조건에 따른 참여 기업 목록의 total 값 가져오기
            int total = userService.getJobPostSrcTotal(cri);
            //위에서 지정해준 조건에 따른 참여 기업 목록 (1페이지당 몇개) 가져오기
            ArrayList<EmpListVO> list = userService.getJobPostSrc(cri);
            List<String> urlList = new ArrayList<>();
            for(EmpListVO vo : list){
                String path = vo.getJpl_fileUuid() + "_" + vo.getJpl_fileName();
                String bucket = vo.getJpl_filePath();
                String url = amazonS3Client.getUrl(bucket, path).toString();
                urlList.add(url);
            }

            //pageVO 생성
            EmpSrcPageVO pageVO = new EmpSrcPageVO(cri, total);

            //list 와 pageVO 를 담아줄 PageGate 생성, 그리고 객체들 담기
            EmpSrcPageGate empPageGate = new EmpSrcPageGate(list, pageVO);

            Map map = new HashMap();
            map.put("urlList", urlList);
            map.put("empSrcPageGate", empPageGate);

            return map;

    }

    //채용공고 검색 목록 갯수 (#### 페이지 네이션 ####)
    @GetMapping(value="/getJobPostSrcTotal")
    public int getJobPostSrcTotal(EmpSrcCriteria cri) {

        int total = userService.getJobPostSrcTotal(cri);

        return total;
    }

    // 유저가 지원한 공고인지 찾기
    @PostMapping(value="/EmpApplied")
    public int EmpApplied(
            @RequestBody HashMap<String,String> map,
            String user_id,
            String jpl_num
            ) {

        user_id = map.get("user_id");
        jpl_num = map.get("jpl_num");

        int result = userService.EmpApplied(user_id, jpl_num);

        return result;
    }

    // 지원 목록에 추가
    @PostMapping(value="/EmpApply")
    public String EmpApply(
                           @RequestBody HashMap<String,String> map,
                           String user_id,
                           String jpl_num,
                           String res_num
                           ) {

        user_id = map.get("user_id");
        jpl_num = map.get("jpl_num");
        res_num = map.get("res_num");

        userService.EmpApply(user_id, jpl_num, res_num);

        return "success";
    }

    //메인화면에서 채용공고 가져오기
    @PostMapping(value = "/getMainJobInfo")
    public ArrayList<EmpListVO> getMainJobInfo() {

        ArrayList<EmpListVO> list = userService.getMainJobInfo();

        for (EmpListVO vo : list) {
            String fileUuid = vo.getJpl_fileUuid();
            String fileName = vo.getJpl_fileName();
            String filePath = vo.getJpl_filePath();

            String path = fileUuid + "_" + fileName;
            String bucket = filePath;
            String url = amazonS3Client.getUrl(bucket, path).toString();

            // 업로드된 기업 로고가 있으면 해당 기업로고 url 저장, 기업 로고 없으면 기본으로 보여줄 이미지 주소를 url에 저장
            if(filePath.equals("_") || fileName == null || fileName.equals("")) {
                vo.setUrl("https://s3.ap-northeast-2.amazonaws.com/mj-final-bucket/image/7c1d62f3-7994-4578-a040-5c617af80686_noPic.jpg");
            } else {
                vo.setUrl(url);
            }
        }
        return list;
    }

    //채용공고 상세페이지에 있는 성별통계구하기
    @PostMapping(value = "/getGendertotal")
    public ArrayList<StatisticVO> getGendertotal(){

        ArrayList<StatisticVO> list = userService.getGendertotal();
        return list;
    }

    //채용공고 상세페이지에 있는 지원자의 이력서 가져오기
    @PostMapping(value = "/getlookPerson")
    public ArrayList<StatisticVO> getlookPerson(@RequestBody EmpVO vo){

        String jpl_num = vo.getJpl_num();
        ArrayList<StatisticVO> list = userService.getlookPerson(jpl_num);
        return list;
    }

    //**********************************************지원현황 관리(유저 마이페이지)**********************************************
    //마이페이지 지원현황 목록 가져오기
    @PostMapping(value="/getApplyList")
    public ArrayList<EmpApplyVO> getApplyList(@RequestBody HashMap<String,String> map,
                                String user_id,
                                String applySel
                                ){

        user_id = map.get("user_id");
        applySel = map.get("applySel");
        ArrayList<EmpApplyVO> list = new ArrayList<EmpApplyVO>();

        if(applySel.equals("all")){
            list = userService.getApplyListAll(user_id);
        }else if(applySel.equals("O")){
            list = userService.getApplyListO(user_id);
        }else if(applySel.equals("X")){
            list = userService.getApplyListX(user_id);
        }

        return list;

    }

    //마이페이지 지원현황 목록 개수 가져오기
    @PostMapping(value="/getApplyListCnt")
    public HashMap<String, Integer> getApplyListCnt(@RequestBody HashMap <String,String> map,
                                                    ArrayList<EmpApplyVO> list1,
                                                    ArrayList<EmpApplyVO> list2,
                                                    ArrayList<EmpApplyVO> list3,
                                                    String user_id
    ){
        user_id = map.get("user_id");

        list1 = userService.getApplyListAll(user_id);
        list2 = userService.getApplyListO(user_id);
        list3 = userService.getApplyListX(user_id);

        HashMap<String, Integer> CntMap = new HashMap<>();

        CntMap.put("all", list1.size());
        CntMap.put("O", list2.size());
        CntMap.put("X", list3.size());

        return CntMap;

    }


    @GetMapping("/uQnAListAxios")
    public PageGate list(Criteria cri) {

        int total = userService.uQnAGetTotal(cri);
        PageVO pageVO = new PageVO(cri, total);
        ArrayList<QnAVO> list = userService.getQnAList(cri);
        PageGate pageGate = new PageGate(list, pageVO);
        return pageGate;
    }

    @PostMapping("/uQnAGetTotal")
    public int uQnAGetTotal(Criteria cri) {
        int total = userService.uQnAGetTotal(cri);

        return total;
    }

}
