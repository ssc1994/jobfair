package com.sungjin.jobfair.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.service.CompanyMypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
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

    //AWS 객체 사용하기
    @Autowired
    public AmazonS3Client amazonS3Client;
    //AWS s3(파일스토리지) 저장소
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

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
    public String modiLogo (@RequestParam("image") MultipartFile file,
                            @RequestParam("com_num") String com_num,
                            CompanyVO cv) throws IOException {


        //AWS S3에 이미지 파일 업로드
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
        String com_fileName = file.getOriginalFilename();
        String com_filePath = bucket+"/image";
        String com_fileUuid = uuid;

        cv.setCom_fileName(com_fileName);
        cv.setCom_filePath(com_filePath);
        cv.setCom_fileUuid(com_fileUuid);

        //업로드된 이미지 파일 정보 Company 테이블에 등록
        comMypageService.modiLogo(cv);

        //업로드된 이미지 파일 url 가져오기
        String path = cv.getCom_fileUuid() + "_" + cv.getCom_fileName();
        String bucket = cv.getCom_filePath();

        String url = amazonS3Client.getUrl(bucket, path).toString();

        return url;


    }

    //comMypage 화면이 나올때 로그인한 기업의 정보를 화면에 뿌려주기위해 데이터를 보내주는 것
    @PostMapping("/getComInfo")
    public CompanyVO getComInfo(@RequestBody Map<String, String> map){

        String com_num = map.get("com_num").replaceAll("\"", "");

        CompanyVO comInfo =  comMypageService.getComInfo(com_num);

        //업로드된 이미지 파일 url 가져와서 CompanyVO에 담기

        if(comInfo.getCom_fileName() == null || comInfo.getCom_fileName().equals("")){
            //업로드된 이미지 파일이 없다면 no img 파일의 url 을 담아줌
            comInfo.setImg_url("https://s3.ap-northeast-2.amazonaws.com/mj-final-bucket/image/0afa39a2-b46b-4ffc-a7c9-677b3aee751c_no-img-icon3.jpg");
        } else {
            //업로드된 이미지 파일이 있다면 이미지 파일의 url 가져와서 담아줌.
            String path = comInfo.getCom_fileUuid() + "_" + comInfo.getCom_fileName();
            String bucket = comInfo.getCom_filePath();
            String url = amazonS3Client.getUrl(bucket, path).toString();
            comInfo.setImg_url(url);
        }

        return comInfo;

    }

    //기업 정보 수정요청
    @PostMapping("modifyInfo")
    public void modifyComInfo(@RequestBody CompanyVO cv){
//        System.out.println(cv.toString());

        comMypageService.modifyComInfo(cv);

    }



}
