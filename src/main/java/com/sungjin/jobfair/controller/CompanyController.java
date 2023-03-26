package com.sungjin.jobfair.controller;

import com.amazonaws.Request;
import com.amazonaws.services.s3.AmazonS3Client;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sungjin.jobfair.PageGate;
import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.PageVO;
import com.sungjin.jobfair.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;


@RestController
@RequestMapping("/jobfair")
public class CompanyController {

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

    @Autowired
    AmazonS3Client amazonS3Client;

    //###############폴더 생성용#####################
    @Value("${project.uploadpath}")
    private String uploadpath;

    //폴더 + 경로 생성용 메서드
    public String makeDir(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String now = sdf.format(date);
        String path = uploadpath + "/" + now;
        File file = new File(path);
        if(file.exists() == false){
            file.mkdir();
        }
        return path;
    }

    @RequestMapping("/imgDisplay")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@RequestBody Map<String,String> map){
        String viewImg = map.get("viewImg");
        System.out.println(viewImg);
        File file = new File(viewImg);
        ResponseEntity<byte[]> result = null;
        try {
            HttpHeaders header = new HttpHeaders();
            header.add("Content-Type", Files.probeContentType(file.toPath()) );
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    //######################기업 메인페이지 ###################
    //현황판( 진행 중, 지원마감, 열람, 미열람) 데이터 가져오기
    @GetMapping("/getStatusData")
    public Map getStatusData(@RequestParam("com_num") String com_num) {
        // 전체 채용공고 수와 진행 중인 공고 수
        ArrayList<Integer> postingArr = companyService.getStatusPosting(com_num);
        // 전체 이력서 수와 열람한 이력서 수
        ArrayList<Integer> resArr = companyService.getStatusRes(com_num);

        //내가 등록한 최신공고 2개
        ArrayList<EmpVO> jplArr = companyService.getRecentPosting(com_num);
        //최근 지원자 2명
        ArrayList<ApplyVO> appArr = companyService.getRecentApplicant(com_num);
        //회사로고 이미지 url, 최신 공고 지원자 수
        ArrayList<String> urlArr = new ArrayList<>();
        ArrayList<Integer> totalAppArr = new ArrayList<>();
        for(EmpVO jpl : jplArr){
            String path = jpl.getJpl_fileUuid() + "_" + jpl.getJpl_fileName();
            String bucket = jpl.getJpl_filePath();
            urlArr.add(amazonS3Client.getUrl(bucket, path).toString());

            totalAppArr.add(companyService.getTotalAl(jpl.getJpl_num()));
        }

        Map map = new HashMap();
        map.put("postingArr", postingArr);
        map.put("resArr", resArr);
        map.put("jplArr", jplArr);
        map.put("appArr", appArr);
        map.put("urlArr", urlArr);
        map.put("totalAppArr", totalAppArr);

        return map;
    }

    @PostMapping("/getResPic")
    public String getImgUrl(@RequestBody Map<String, String> map) {
        String path = map.get("picUuid") + "_" + map.get("pic_name");
        String bucket = map.get("picPath");
        String url = amazonS3Client.getUrl(bucket, path).toString();
        System.out.println("url = " + url);
        return url;
    }


    //######################채용공고##########################
    //(회사정보)com_num을 기준으로 회사테이블에서 정보를 불러오는 메서드
    @PostMapping(value = "/compInfo")
    public Map<String, String> userInfo(@RequestBody Map<String,String> param){
        String com_num = param.get("com_num");
        CompanyVO vo =  companyService.info(com_num);

        Map<String, String> map = new HashMap<>();
        map.put("com_num",vo.getCom_num());
        map.put("com_name",vo.getCom_name());
        map.put("com_phone",vo.getCom_phone());
        map.put("com_email",vo.getCom_email());
        map.put("com_address",vo.getCom_address());
        map.put("com_category",vo.getCom_category());
        map.put("com_ceo",vo.getCom_ceo());
        map.put("com_establishmentDate",vo.getCom_establishmentDate());
        map.put("com_businessRegistration",vo.getCom_businessRegistration());

        return map;
    }
    //채용공고 등록 메서드
    @PostMapping(value = "/EmpRegist", consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.MULTIPART_FORM_DATA_VALUE})
    public String EmpRegist(@RequestPart("empData") String empData, @RequestParam(value="files", required = false) MultipartFile file){

        ObjectMapper mapper = new ObjectMapper();
        EmpVO vo = null;
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        //받아온 empData를 파싱
        try {
            vo = mapper.readValue(empData, EmpVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        //파일명 처리
        String originName = file.getOriginalFilename();
        //폴더생성
        String filePath = makeDir();
        //중복파일처리용 UUID 생성
        String uuid = UUID.randomUUID().toString();
        //최종 저장 경로
        String saveName = filePath+"/"+uuid+"-"+originName;

        //vo에파일관련 값 추가
        vo.setJpl_fileName(file.getOriginalFilename());
        vo.setJpl_filePath(filePath);
        vo.setJpl_fileUuid(uuid);

        //파일 업로드
        try (FileOutputStream writer = new FileOutputStream(saveName)){
            writer.write(file.getBytes());
        }catch (Exception e){
            return "fail";
        }
        int result = companyService.empRegist(vo);
        return "등록완료"+result;
    }

    //채용공고 수정 메서드
    @PostMapping(value = "/empModify", consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.MULTIPART_FORM_DATA_VALUE})
    public String empModify(@RequestPart("empData") String empData, @RequestParam(value="files", required = false) MultipartFile file){

        ObjectMapper mapper = new ObjectMapper();
        EmpVO vo = null;
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        //받아온 empData를 파싱
        try {
            vo = mapper.readValue(empData, EmpVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        //파일명 처리
        String originName = file.getOriginalFilename();
        //폴더생성
        String filePath = makeDir();
        //중복파일처리용 UUID 생성
        String uuid = UUID.randomUUID().toString();
        //최종 저장 경로
        String saveName = filePath+"/"+uuid+"-"+originName;

        //vo에파일관련 값 추가
        vo.setJpl_fileName(file.getOriginalFilename());
        vo.setJpl_filePath(filePath);
        vo.setJpl_fileUuid(uuid);

        //파일 업로드
        try (FileOutputStream writer = new FileOutputStream(saveName)){
            writer.write(file.getBytes());
        }catch (Exception e){
            return "fail";
        }
        int result = companyService.empModify(vo);
        
        return "수정완료"+result;
    }


    //(채용공고정보) jpl번호를 기준으로 jpl테이블에서 데이터를 불러오는 메서드
    @GetMapping(value="/empData")
    public EmpVO getEmpData(@RequestParam("jpl_num") int jpl_num){
        EmpVO vo = companyService.getEmpData(jpl_num);
        //채용공고 정보 확인용 sout
        System.out.println(vo);
        return vo;
    }
    //기업이 등록한 채용공고 리스트 가져오기
    @PostMapping(value="/getComJobPosingList")
    public Map getComJobPosingList (@RequestBody Map<String, String> map) {
        String com_num = map.get("com_num");

        int page = Integer.parseInt(map.get("page"));
        int amount = Integer.parseInt(map.get("amount"));
        int total = companyService.getTotalJpl(com_num);

        //페이지네이션
        Criteria cri = new Criteria(page, amount);
        PageVO pageVO = new PageVO(cri, total);

        Map paramMap = new HashMap();
        paramMap.put("cri", cri);
        paramMap.put("com_num", com_num);

        // 채용 공고에 지원한 지원자들 리스트
        ArrayList<EmpVO> jplList = companyService.getComJobPosingList(paramMap);
        ArrayList<Integer> countAppList = new ArrayList<>();

        for(EmpVO jpl : jplList) {
            countAppList.add(companyService.getTotalAl(jpl.getJpl_num()));
        }

        System.out.println("countAppList = " + countAppList);

        paramMap.clear();
        paramMap.put("pageVO", pageVO);
        paramMap.put("jplList", jplList);
        paramMap.put("countAppList", countAppList);
        return paramMap; //반환값 변경해야함
    }

    //채용공고에 지원한 지원자 리스트
    @PostMapping(value="getApplicantList")
    public Map getApplicantList(@RequestBody Map<String, String> map){
        String jpl_num = map.get("jpl_num");

        int page = Integer.parseInt(map.get("page"));
        int amount = Integer.parseInt(map.get("amount"));
        int total = companyService.getTotalAl(jpl_num);

        Criteria cri = new Criteria(page, amount);
        PageVO pageVO = new PageVO(cri, total);

        Map paramMap = new HashMap();
        paramMap.put("cri", cri);
        paramMap.put("jpl_num", jpl_num);

        ArrayList<ApplyVO> applicantList = companyService.getApplicantList(paramMap);
        paramMap.clear();
        paramMap.put("pageVO", pageVO);
        paramMap.put("applicantList", applicantList);

        return paramMap;
    }

    //이력서 열람 / 미열람 상태변화
    @GetMapping(value = "chgApplicantState")
    public String chgApplicantState(@RequestParam("res_num") String res_num,
                                    @RequestParam("al_state") String al_state) {

        Map<String, String> map = new HashMap<>();
        map.put("res_num", res_num);
        map.put("al_state", al_state);

        companyService.chgApplicantState(map);

        return "변경 성공";
    }


    //##################### Q&A ###########################
    //Q&A 답변 정보 얻기   ///getComQnADetail 랑 동일( 합쳐야댐)
    @GetMapping("/getQnAReply")
    public QnAVO getQnAReply(@RequestParam("qa_num") int qa_num) {
        QnAVO vo = companyService.getQnAReply(qa_num);
        return vo;
    }
    ///getQnaReply 랑 동일( 합쳐야댐)
    @GetMapping(value = "/getComQnADetail")
    public QnAVO getComQnADetail(@RequestParam("qa_num") int qa_num) {

        System.out.println("기업 QnA 디테일데이터");
        QnAVO vo = companyService.getComQnADetail(qa_num);
        System.out.println(vo);
        System.out.println("야호");

        return vo;
    }
    //큐앤에이 답변 등록
    @PostMapping(value = "/cqnaRegist")
    public String cqnaRegist(@RequestBody QnAVO vo) {
        companyService.cqnaRegist(vo);
        return "success";
    }
    //큐앤에이 목록
//    @GetMapping(value = "/cgetQnAList")
//    public ArrayList<QnAVO> cgetQnAList(@RequestBody HashMap<String, Object> map,
//                                        String com_num,
//                                        Criteria cri) {
//
//        com_num = (String)map.get("com_num");
//        cri = (Criteria) map.get("cri");
//
//        ArrayList<QnAVO> list = companyService.cgetQnAList(com_num, cri);
//        System.out.println(com_num);
//        System.out.println(list.toString());
//        return list;
//    }
    //큐앤에이 목록
    @GetMapping(value = "/cgetQnAList")
    public ArrayList<QnAVO> cgetQnAList(String com_num, Criteria cri) {

//        com_num = (String)map.get("com_num");
//        cri = (Criteria) map.get("cri");

        System.out.println("컴넘은 " + com_num);
        System.out.println(cri.toString());

        ArrayList<QnAVO> list = companyService.cgetQnAList(com_num, cri);

        return list;
    }

    //QnA에서 기업정보 데이터 가져오기
    @GetMapping(value = "/cQnAInfo")
    public UserVO cQnAInfo(@RequestParam("user_id") String user_id) {
        System.out.println("유저아이디:" + user_id);
        UserVO vo = companyService.cQnAInfo(user_id);
        System.out.println("기업VO");
        System.out.println(vo.toString());
        return vo;
    }

    //큐앤에이 페이지네이션
    //다시해야됨
    @GetMapping("/cQnAListAxios")
    public PageGate list(String com_num, Criteria cri) {

        System.out.println(com_num);
        System.out.println(cri.toString());


        int total = companyService.cQnAGetTotal(cri, com_num);
        PageVO pageVO = new PageVO(cri, total);


        ArrayList<QnAVO> list = companyService.cgetQnAList(com_num, cri);

        PageGate pageGate = new PageGate(list, pageVO);

        return pageGate;
    }

    //아니면,,, com_num을 받는 메서드를 따로 만들어서 companyService. 이런식으로 가져오는건,,,
//
//    @PostMapping("/cQnAGetTotal")
//    public int cQnAGetTotal(Criteria cri) {
//        int total = companyService.cQnAGetTotal(cri);
//
//        return total;
//    }

}