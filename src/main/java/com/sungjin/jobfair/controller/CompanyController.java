package com.sungjin.jobfair.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.CompanyService;
import org.apache.ibatis.javassist.Loader;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;

import org.springframework.ui.Model;
import java.util.ArrayList;
import org.springframework.http.MediaType;
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

    //###############폴더 생성용#####################
    @Value("${project.uploadpath}")
    private String uploadpath;

    //폴더 + 경로 생성용 메서드
    public String makeDir(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String now = sdf.format(date);
        String path = uploadpath + "\\" + now;
        File file = new File(path);
        if(file.exists() == false){
            file.mkdir();
        }
        return path;
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
        //(채용공고정보) jpl번호를 기준으로 jpl테이블에서 데이터를 불러오는 메서드
    @GetMapping(value="/empData")
    public EmpVO getEmpData(@RequestParam("num") int jpl_num){
        EmpVO vo = companyService.getEmpData(jpl_num);
        //채용공고 정보 확인용 sout
        System.out.println(vo);
        return vo;
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
        //큐앤에이 목록 - done
    @PostMapping(value = "/cgetQnAList")
    public ArrayList<QnAVO> cgetQnAList() {
        ArrayList<QnAVO> list = companyService.cgetQnAList();
        System.out.println(list.toString());
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

    //

}