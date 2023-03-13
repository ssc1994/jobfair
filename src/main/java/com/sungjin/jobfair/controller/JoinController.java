package com.sungjin.jobfair.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.joinService.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/jobfair")
public class JoinController {

    @Autowired
    @Qualifier("joinService")
    private JoinService joinService;

    //중복 아이디 확인
    @PostMapping("/checkSameId")
    public ResponseEntity checkSameId(@RequestBody UserVO vo) {

        if (joinService.checkSameId(vo) == 0) {
            //중복 아이디가 없음
            return new ResponseEntity<>("true", HttpStatus.OK);
        } else {
            //중복 아이디가 있음
            return new ResponseEntity<>("false", HttpStatus.OK);
        }


    }

    //유저 or 기업 회원가입 처리
    @PostMapping("/uJoin")
    public String uJoin(@RequestBody ObjectNode node,
                        UserVO uv,
                        CompanyVO cv) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            uv = mapper.treeToValue(node.get("userData"), UserVO.class);
            cv = mapper.treeToValue(node.get("comData"), CompanyVO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("uv = " + uv);
        System.out.println("cv = " + cv);
        System.out.println(uv.getMg_auth().equals("2"));
        System.out.println(uv.getMg_auth().equals("1"));

        return "success";

    }


}