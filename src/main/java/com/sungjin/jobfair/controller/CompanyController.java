package com.sungjin.jobfair.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.CompanyService;
import org.apache.ibatis.javassist.Loader;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
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




    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

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


        System.out.println(vo.toString());
        //파일 업로드
        try (FileOutputStream writer = new FileOutputStream(saveName)){
            writer.write(file.getBytes());
        }catch (Exception e){
            return "fail";
        }
        int result = companyService.empRegist(vo);
        return "등록완료"+result;
    }


    @PostMapping(value = "/compInfo")
    public Map<String, String> userInfo(@RequestBody Map<String,String> param){
        String com_num = param.get("com_num");
        CompanyVO vo =  companyService.info(com_num);
        System.out.println(vo);

        Map<String, String> map = new HashMap<>();
        map.put("com_num",vo.getCom_num());
        map.put("com_name",vo.getCom_name());
        map.put("com_phone",vo.getCom_phone());

        return map;
    }

    @GetMapping(value="/empData")
    public EmpVO getEmpData(@RequestParam("num") int jpl_num){
        EmpVO vo = companyService.getEmpData(jpl_num);
        return vo;
    }

}
