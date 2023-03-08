package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.joinService.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/jobfair")
public class JoinController {

    @Autowired
    @Qualifier("joinService")
    private JoinService joinService;

    //중복 아이디 확인
    @PostMapping("/checkSameId")
    public ResponseEntity checkSameId(@RequestBody UserVO vo){

        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dateFormat.format(today));

        if(joinService.checkSameId(vo) == 0){
            //중복 아이디가 없음
            return new ResponseEntity<>("true", HttpStatus.OK);
        } else {
            //중복 아이디가 있음
            return new ResponseEntity<>("false", HttpStatus.OK);
        }

    }

    //유저 회원가입 처리
    @PostMapping("/uJoin")
    public void uJoin(@ModelAttribute UserVO vo, HttpServletResponse response) throws IOException {

        //가입일을 user_regDate에 저장
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        vo.setUser_regDate(dateFormat.format(today));

        joinService.uJoin(vo);
        response.sendRedirect(
                "http://localhost:8081/uMainView"
        );

    }
}