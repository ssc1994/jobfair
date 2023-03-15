package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/jobfair")
public class UserController {

    //인터페이스 타입 선언
    @Autowired
    @Qualifier("userService")
    private UserService userService;


    //큐앤에이 등록 폼요청
    @PostMapping(value = "/qnaRegist")
    public String qnaRegist(@RequestBody QnAVO vo) {
        System.out.println("유저컨트롤러 시작");
        userService.qnaRegist(vo);
        System.out.println("유저컨트롤러 종료");
        return "success";
    }

    //큐앤에이 목록
    @PostMapping(value = "/getQnAList")
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
        System.out.println(list.toString());

        return list;
    }

    //채용공고 검색

    @GetMapping(value="/getJobPostSrc")
    public ArrayList<EmpVO> getJobPostSrc(@RequestParam("jpl_Form") Model model, String str) {

        ArrayList<EmpVO> list = userService.getJobPostSrc(str);
        model.addAttribute("list", list);
        System.out.println(list.toString());

        return list;
    }

}
