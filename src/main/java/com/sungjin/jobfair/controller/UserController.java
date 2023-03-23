package com.sungjin.jobfair.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.sungjin.jobfair.PageGate;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.PageVO;
import org.springframework.boot.Banner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    
    //application.properties에서 경로 가져오기
//    @Value("${project.uploadpath}")
//    private String uploadpath;
//
//    //**********************************************이력서**********************************************
//        //파일 생성 시 날짜 별로 폴더 생성 후 저장할 경로 생성
//    public String makeDir() {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//        String now = sdf.format(date);
//
//        String path = uploadpath + "\\" + now;
//        File file = new File(path);
//        if (file.exists() == false) {
//            file.mkdir();
//        }
//        return path;
//    }

        //이력서 목록가져오기
    @PostMapping(value = "/resumeInfo")
    public ArrayList<ResumeVO> resumeInfo(@RequestBody UserVO vo) {

        String user_id = vo.getUser_id();
        ArrayList<ResumeVO> list = userService.resumeInfo(user_id);

        return list;
    }

        //이력서 삭제하기
    @PostMapping(value = "/deleteResume")
    public void deleteResume(@RequestBody Map<String, String> map) {
        String res_num = map.get("res_num");

        userService.deleteEdu(res_num);
        userService.deleteWe(res_num);
        userService.deleteCert(res_num);
        userService.deleteResume(res_num);

    }
        //이력서 등록
    @PostMapping(value = "/regResume",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String regResume(@RequestPart("res_img") MultipartFile file,
                            @RequestPart("resData") ObjectNode node,
                            ResumeVO resumeVO,
                            ArrayList<EduVO> eduList,
                            ArrayList<WeVO> weList,
                            ArrayList<CertVO> certList) throws IOException {

        //AWS S3 파일 업로드
        String tmpName = file.getOriginalFilename();
        File uploadFile = new File(tmpName); //파일 이름
        FileOutputStream fos = new FileOutputStream(uploadFile);
        String uuid = UUID.randomUUID().toString(); //uuid
        String fileName = uuid + "_" + tmpName; //uuid + 파일이름
        fos.write(file.getBytes());
        fos.close();

        amazonS3Client.putObject(new PutObjectRequest(bucket+"/image", fileName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));


        //파일 객체 분해 및 경로+이름 지정
        String pic_name = file.getOriginalFilename();
        String pic_path = bucket+"/image";
        String pic_uuid = uuid;
//        String saveName = pic_path + "/" + pic_uuid + "_" + pic_name;
        ObjectMapper mapper = new ObjectMapper();
        try {
            //넘어온 이미지파일 먼저 생성
//            File save = new File(saveName);
//            file.transferTo(save);
            //Json을 객체로 변환
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
            edu.setEdu_grades("4.0");
            edu.setEdu_totalGrades("4.5");
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
        System.out.println(url);

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
    public String regResume(@RequestPart("res_img") MultipartFile file,
                            @RequestPart("resData") ObjectNode node) throws IOException {
        ResumeVO resumeVO = new ResumeVO();
        ArrayList<EduVO> eduList = new ArrayList<>();
        ArrayList<WeVO> weList = new ArrayList<>();
        ArrayList<CertVO> certList = new ArrayList<>();

        //파일 객체 분해 및 경로+이름 지정
        String pic_name = file.getOriginalFilename();
        String pic_path = bucket+"/image";
        String pic_uuid = UUID.randomUUID().toString();
        String saveName = pic_path + "/" + pic_uuid + "_" + pic_name;
        ObjectMapper mapper = new ObjectMapper();
        try {
            //넘어온 이미지파일 먼저 생성
            File save = new File(saveName);
            file.transferTo(save);
            //Json을 객체로 변환
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
        int res_num = resumeVO.getRes_num();
        String user_id = resumeVO.getUser_id();

        for (EduVO edu : eduList) {
            edu.setRes_num(res_num);
            edu.setEdu_totalGrades("4.5");
            userService.modiResEdu(edu);
        }
        for (WeVO we : weList) {
            we.setRes_num(res_num);
            userService.modiResWe(we);
        }
        for (CertVO cert : certList) {
            cert.setRes_num(res_num);
            userService.modiResCert(cert);
        }


        return null;
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

    //채용상세공고에서 질문하기 버튼 누를경우 기업정보 넘기는 메서드
    //(채용공고정보) jpl번호를 기준으로 jpl테이블에서 데이터를 불러오는 메서드
//    @PostMapping("/uQnABtnClick")
//        public QnAVO uQnABtnClick(){
//            QnAVO vo = userService.uQnABtnClick();
//            System.out.println(vo);
//            return vo;
//        }


    //**********************************************채용공고**********************************************
        //채용공고 목록
    @PostMapping(value = "/getJobPostList")
    public ArrayList<EmpVO> getJobPostList(Model model) {

        ArrayList<EmpVO> list = userService.getJobPostList();
        model.addAttribute("list", list);
//        System.out.println(list.toString());

        return list;
    }
        //채용공고 검색
    @PostMapping(value="/getJobPostSrc",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<EmpVO> getJobPostSrc(@RequestBody EmpSearchVO vo,
                                          String [] jpl_locationSi,
                                          String [] jpl_locationGu,
                                          String [] jpl_duty,
                                          String inputSearch,
                                          String[] jpl_workHistory,
                                          String[] jpl_education,
                                          String[] jpl_salary,
                                          String[] jpl_certificate,
                                          String[] jpl_conditions,
                                          String[] jpl_workForm
                                       ) {

        jpl_locationSi = vo.getJpl_duty();
        jpl_locationGu = vo.getJpl_locationGu();
        jpl_duty = vo.getJpl_workHistory();
        jpl_workHistory = vo.getJpl_workHistory();
        jpl_education = vo.getJpl_education();
        jpl_salary = vo.getJpl_salary();
        jpl_salary = vo.getJpl_salary();
        jpl_certificate = vo.getJpl_certificate();
        jpl_conditions = vo.getJpl_conditions();
        jpl_workForm = vo.getJpl_workForm();
        inputSearch = vo.getInputSearch();

        ArrayList<EmpVO> list = userService.getJobPostSrc(vo);

        return list;
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


        //기업이 작성한 채용공고 내용 가져오는 메서드 (박희진 작성중)
//    @PostMapping( value = "EmpRegistInfo")
//    public ArrayList<EmpVO> EmpRegistInfo(Model model){
//
//        ArrayList<EmpVO> list = userService.EmpRegistInfo();
//        model.addAttribute("list", list);
//        System.out.println("controller탐");
//
//        return list;
//    }


    //**********************************************페이지네이션**********************************************
//    @PostMapping(value = "/getQnATotal")
////    public int getQnATotal() {
////       int total = userService.getQnATotal();
////        System.out.println(total);
////        return total;
////    }



    //페이지네이션

//    public ResponseEntity <Map<String, Object>> uQnAListAxios(Criteria cri) {
//
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("pageVOList", userService.getQnAList(cri));
//        map.put("totalPage", userService.uQnAGetTotal(cri));
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }

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