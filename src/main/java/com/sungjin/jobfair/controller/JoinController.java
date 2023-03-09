package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.CompanyVO;
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

        if(joinService.checkSameId(vo) == 0){
            //중복 아이디가 없음
            return new ResponseEntity<>("true", HttpStatus.OK);
        } else {
            //중복 아이디가 있음
            return new ResponseEntity<>("false", HttpStatus.OK);
        }

    }

    //유저 or 기업 회원가입 처리
    @PostMapping("/uJoin")
    public void uJoin(UserVO vo,
                      CompanyVO comVO,
                      HttpServletResponse response) throws IOException {

        //가입일을 user_regDate에 저장
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        vo.setUser_regDate(dateFormat.format(today));

        //user 가입정보 데이터베이스 등록
        joinService.uJoin(vo);
        response.sendRedirect(
                "http://localhost:8081/uMainView"
        );

        //기업 가입정보 데이터베이스 등록
        System.out.println(comVO.getCom_name());
        System.out.println(comVO.getCom_ceo());
        System.out.println(comVO.getCom_address());
        System.out.println(comVO.getCom_email());
        System.out.println(comVO.getCom_phone());
        System.out.println(comVO.getCom_businessRegistration());
        System.out.println(comVO.getCom_establishmentDate());
        System.out.println(comVO.getCom_category());

    }



}