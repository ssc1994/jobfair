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
import org.springframework.security.crypto.password.PasswordEncoder;
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

//회원가입 컨트롤러
@RestController
@RequestMapping("/jobfair")
public class JoinController {

    @Autowired
    @Qualifier("joinService")
    private JoinService joinService;

    @Autowired
    private PasswordEncoder pwEncoder;

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
    public String uJoin(@RequestBody ObjectNode saveObj,
                        UserVO uv,
                        CompanyVO cv) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            uv = mapper.treeToValue(saveObj.get("userData"), UserVO.class);
            cv = mapper.treeToValue(saveObj.get("comData"), CompanyVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //user_pw 암호화
        String rawPw = ""; // 사용자가 저장한 비밀번호
        String encodePw= ""; // 암호화된 비밀번호

        rawPw = uv.getUser_pw();
        encodePw = pwEncoder.encode(rawPw);
        uv.setUser_pw(encodePw);

        //user 가입자 정보 등록처리
        System.out.println(uv.toString());
        joinService.uJoin(uv);

        //mg_auth 가 2이면 기업가입자 이므로 기업정보 등록처리
        if(uv.getMg_auth().equals("2")){
            System.out.println(cv.toString());
            joinService.cJoin(cv);

            //user 테이블에서 company 테이블의 com_num을 참조하므로
            //현재 생성된 company 테이블 행의 com_num 을 다시 방금생성된
            //user테이블의 가입자 id에 해당하는 행의 com_num에 넣어주는 처리.
            joinService.insertComNum(uv);

        }

        return "success";

    }
}