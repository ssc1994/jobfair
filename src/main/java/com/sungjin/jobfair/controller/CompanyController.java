package com.sungjin.jobfair.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sungjin.jobfair.PageGate;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.PageVO;
import com.sungjin.jobfair.service.CompanyService;
import org.apache.ibatis.javassist.Loader;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/jobfair")
public class CompanyController {

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

    @Autowired
    AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

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
    public String EmpRegist(@RequestPart("empData") String empData, @RequestParam(value="files", required = false) MultipartFile file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        EmpVO vo = null;
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        //받아온 empData를 파싱
        try {
            vo = mapper.readValue(empData, EmpVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }

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

        //vo에파일관련 값 추가
        vo.setJpl_fileName(file.getOriginalFilename());
        vo.setJpl_filePath(bucket+"/image");
        vo.setJpl_fileUuid(uuid);

        int result = companyService.empRegist(vo);

        return "등록완료"+result;
    }

    //채용공고 수정 메서드
    @PostMapping(value = "/empModify", consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.MULTIPART_FORM_DATA_VALUE})
    public String empModify(@RequestPart("empData") String empData, @RequestParam(value="files", required = false) MultipartFile file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        EmpVO vo = null;
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        //받아온 empData를 파싱
        try {
            vo = mapper.readValue(empData, EmpVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }

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

        //vo에파일관련 값 추가
        vo.setJpl_fileName(file.getOriginalFilename());
        vo.setJpl_filePath(bucket+"/image");
        vo.setJpl_fileUuid(uuid);

        int result = companyService.empModify(vo);
        
        return "수정완료"+result;
    }


    //(채용공고정보) jpl번호를 기준으로 jpl테이블에서 데이터를 불러오는 메서드
    @GetMapping(value="/empData")
    public EmpVO getEmpData(@RequestParam("jpl_num") int jpl_num){
        EmpVO vo = companyService.getEmpData(jpl_num);

        //aws에 분해해서 등록해둔 사진 데이터를 불러옴
        String path = vo.getJpl_fileUuid() + "_" + vo.getJpl_fileName();
        String bucket = vo.getJpl_filePath();

        String url = amazonS3Client.getUrl(bucket, path).toString();
        System.out.println(url);
        if(!path.equals("_")){
            vo.setUrl(url);
        }

        //채용공고 정보 확인용 sout
        System.out.println(vo);
        return vo;
    }
    //기업이 등록한 채용공고 리스트 가져오기
    @PostMapping(value="/getComJobPosingList")
    public ArrayList<EmpVO> getComJobPosingList (@RequestBody Map<String, String> map) {
        String com_num = map.get("com_num");
        ArrayList<EmpVO> list = companyService.getComJobPosingList(com_num);
        return companyService.getComJobPosingList(com_num);
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