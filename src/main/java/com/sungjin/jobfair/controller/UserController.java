package com.sungjin.jobfair.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/jobfair")
public class UserController {

    @Value("${project.uploadpath}")
    private String uploadpath;

    //파일 생성 시 날짜 별로 폴더 생성 후 저장할 경로 생성
    public String makeDir() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String now = sdf.format(date);

        System.out.println("uploadpath = " + uploadpath);
        String path = uploadpath + "\\" + now;
        File file = new File(path);
        if (file.exists() == false) {
            file.mkdir();
        }
        return path;
    }

    //인터페이스 타입 선언
    @Autowired
    @Qualifier("userService")
    private UserService userService;


    //큐앤에이 
    @PostMapping(value = "/qnaRegist")
    public String qnaRegist(@RequestBody QnAVO vo) {
        userService.qnaRegist(vo);
        return "success";
    }

    //큐앤에이 목록
    @PostMapping (value = "/getQnAList")
    public  ArrayList<QnAVO> getQnAList(Model model) {

        ArrayList<QnAVO> list = userService.getQnAList();
        model.addAttribute("list", list);
        System.out.println(list.toString());

        return list;
    }

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
    public ArrayList<EmpVO> getJobPostSrc(@RequestBody ObjectNode node,
                                          ArrayList<EmpSearchVO> jpl_duty,
                                          ArrayList<EmpSearchVO> jpl_workHistory,
                                          ArrayList<EmpSearchVO> jpl_workForm,
                                          ArrayList<EmpSearchVO> jpl_education,
                                          ArrayList<EmpSearchVO> jpl_conditions,
                                          ArrayList<EmpSearchVO> jpl_certificate,
                                          ArrayList<EmpSearchVO> jpl_salary,
                                          ArrayList<EmpSearchVO> jpl_locationSi,
                                          ArrayList<EmpSearchVO> jpl_locationGu
                                          ) {
        //System.out.println(vo);

        //System.out.println("검색메서드"+list.toString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        //System.out.println(mapper.);
        System.out.println("node = " + node);

        ArrayList<EmpVO> empvo = new ArrayList<>();

        try {
            System.out.println(1);
            ArrayList tmp_jpl_duty = mapper.treeToValue(node.get("jpl_duty"), ArrayList.class);
            ArrayList tmp_jpl_workHistory = mapper.treeToValue(node.get("jpl_workHistory"), ArrayList.class);
            ArrayList tmp_jpl_workForm = mapper.treeToValue(node.get("jpl_workForm"), ArrayList.class);
            ArrayList tmp_jpl_education = mapper.treeToValue(node.get("jpl_education"), ArrayList.class);
            ArrayList tmp_jpl_conditions = mapper.treeToValue(node.get("jpl_conditions"), ArrayList.class);
            ArrayList tmp_jpl_certificate = mapper.treeToValue(node.get("jpl_certificate"), ArrayList.class);
            ArrayList tmp_jpl_salary = mapper.treeToValue(node.get("jpl_salary"), ArrayList.class);
            ArrayList tmp_jpl_locationSi = mapper.treeToValue(node.get("jpl_locationSi"), ArrayList.class);
            ArrayList tmp_jpl_locationGu = mapper.treeToValue(node.get("jpl_locationGu"), ArrayList.class);

            System.out.println(tmp_jpl_duty.toString());

            jpl_duty = mapper.convertValue(tmp_jpl_duty.toString(), new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_workHistory = mapper.convertValue(tmp_jpl_workHistory, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_workForm = mapper.convertValue(tmp_jpl_workForm, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_education = mapper.convertValue(tmp_jpl_education, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_conditions = mapper.convertValue(tmp_jpl_conditions, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_certificate = mapper.convertValue(tmp_jpl_certificate, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_salary = mapper.convertValue(tmp_jpl_salary, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_locationSi = mapper.convertValue(tmp_jpl_locationSi, new TypeReference<ArrayList<EmpSearchVO>>(){});
            jpl_locationGu = mapper.convertValue(tmp_jpl_locationGu, new TypeReference<ArrayList<EmpSearchVO>>(){});

            System.out.println(jpl_duty);
            for(EmpSearchVO vo : jpl_duty){
                System.out.println(vo);
                userService.getJobPostSrc(vo);




            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return empvo;
    }


    //큐앤에이 상세페이지 데이터 불러오기
    @GetMapping(value = "/uQnADetailView")
    public QnAVO getQnADetail(@RequestParam("qa_num") int qa_num) {

        QnAVO vo = userService.getQnADetail(qa_num);
        System.out.println("유저VO");
        System.out.println(vo.toString());


        return vo;
    }

    //이력서 내용가져오기
    @PostMapping(value = "/resumeInfo")
    public ArrayList<ResumeVO> resumeInfo(Model model) {

        ArrayList<ResumeVO> list = userService.resumeInfo();
        model.addAttribute("list", list);

        return list;
    }
    //이력서 등록
    @PostMapping(value = "/regResume",
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String regResume (@RequestPart("res_img") MultipartFile file,
                             @RequestPart("resData") ObjectNode node,
                             ResumeVO resumeVO,
                             EduVO eduVO,
                             CertVO certVO,
                             ArrayList<WeVO> weList) {

        //파일 객체 분해 및 경로+이름 지정
        String pic_name = file.getOriginalFilename();
        String pic_path = makeDir();
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
            eduVO = mapper.treeToValue(node.get("eduInfo"), EduVO.class);
            certVO = mapper.treeToValue(node.get("certInfo"), CertVO.class);
            weList = mapper.treeToValue(node.get("weInfo"), ArrayList.class);
            System.out.println("weList = " + weList);
//            for(WeVO we : weList){
//                service(we)
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    @PostMapping(value = "/uploadImg")
    public String uploadImg (@RequestParam("res_img") MultipartFile file) {


        String pic_name = file.getOriginalFilename();
        String pic_path = makeDir();
        String pic_uuid = UUID.randomUUID().toString();
        String saveName = pic_path + "/" + pic_uuid + "_" + pic_name;

        try {
            File save = new File(saveName);
            file.transferTo(save);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
