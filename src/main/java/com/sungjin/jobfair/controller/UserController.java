package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


    //큐앤에이 등록
    @PostMapping(value = "/qnaRegist")
    public String qnaRegist(@RequestBody QnAVO vo) {
        userService.qnaRegist(vo);
        return "success";
    }

    //채용공고 상세 검색 폼 요청
    @PostMapping(value = "/uJobPost")
    public String uJobPost() {
        System.out.println("잡포스트 시작");
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

    //큐앤에이 상세페이지 데이터 불러오기
    @GetMapping(value = "/uQnADetailView")
    public QnAVO getQnADetail(@RequestParam("qa_num") int qa_num) {

        QnAVO vo = userService.getQnADetail(qa_num);
        System.out.println("유저VO");
        System.out.println(vo.toString());


        return vo;
    }

}
