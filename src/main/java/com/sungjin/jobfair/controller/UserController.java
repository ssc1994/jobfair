package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //채용공고 상세 검색 폼 요청
    @PostMapping(value = "/uJobPost")
    public String uJobPost() {
        System.out.println("잡포스트 시작");
        return "success";
    }


}