package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.service.CompanyMypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/jobfair/companyMypage")
public class CompanyMypageController {

    @Autowired
    @Qualifier("comMypageService")
    public CompanyMypageService comMypageService;

    //application.properties에서 경로 가져오기
    @Value("${project.uploadpath}")
    private String uploadpath;

    //파일 생성시 날짜별로 폴더 생성 후 저장할 경로 생성
//    public String makeDir() {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//        String now = sdf.format(date);
//
//        System.out.println("uploadpath = " + uploadpath);
//        String path = uploadpath + "\\" + now;
//        File file = new File(path);
//        if (file.exists() == false) {
//            file.mkdir();
//        }
//        return path;
//    }

    public String makeDir() {
        File file = new File(uploadpath);
        if (file.exists() == false) {
            file.mkdir();
        }
        return uploadpath;
    }


    @PostMapping("/modiLogo")
    public HashMap modiLogo (@RequestParam("image") MultipartFile file,
                            @RequestParam("com_num") String com_num,
                            CompanyVO cv) {
//        System.out.println(file);
//        System.out.println(com_num);
        String num = com_num.replaceAll("\"", "");
//        System.out.println(num);

        //파일명 처리
        String imgName = file.getOriginalFilename();
        //폴더 생성
        String imgPath = makeDir();
        //중복파일처리용 UUID 생성
        String uuid = UUID.randomUUID().toString();
        //최종 저장 경로
        String saveName = imgPath+"/"+uuid+"-"+imgName;

        //넘어온 이미지파일 먼저 생성
        File save = new File(saveName);
        try {
            file.transferTo(save); //이 메소드에 의해 저장 경로에 실질적으로 file이 생성됨
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //업로드된 이미지 파일 정보 해당 기업의 DB에 저장.
        cv.setCom_num(num);
        cv.setCom_fileName(imgName);
        cv.setCom_filePath(imgPath);
        cv.setCom_fileUuid(uuid);

        comMypageService.modiLogo(cv);


        //이제 업로드된 이미지 파일 불러와서 화면에 뿌려줘야함.


        HashMap result = new HashMap();
        result.put("filePath", saveName);
        return result;
    }

    //comMypage 화면이 나올때 로그인한 기업의 정보를 화면에 뿌려주기위해 데이터를 보내주는 것
    @PostMapping("/getComInfo")
    public CompanyVO getComInfo(@RequestBody Map<String, String> map){

        String com_num = map.get("com_num").replaceAll("\"", "");

        CompanyVO comInfo =  comMypageService.getComInfo(com_num);

        return comInfo;

    }

    //기업 정보 수정요청
    @PostMapping("modifyInfo")
    public void modifyComInfo(@RequestBody CompanyVO cv){
//        System.out.println(cv.toString());

        comMypageService.modifyComInfo(cv);

    }



}
