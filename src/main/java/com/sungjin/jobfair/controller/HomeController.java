package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.TokenUtils;
import com.sungjin.jobfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody Map<String,String> param){

        // 입력받은 아이디 / 비밀번호 / auth
        String id = param.get("id");
        String pw = param.get("pw");
        String auth = param.get("auth");

        //서비스 영역으로 보내서 db와 확인하기
        UserVO tempVO = UserVO.builder().user_id(id).user_pw(pw).mg_auth(auth).build();

        //받은 데이터를 vo로 만들어서 보냄
        UserVO vo = userService.login(tempVO);

        //서비스 영역에서 확인후 성공이라면 session생성
        System.out.println("서버에서 검색결과");
        System.out.println(vo);


        if(vo!=null){
            //세션에 넣을 jwt 생성
            String token = TokenUtils.generateToken(vo);
            System.out.println("token :" +token);
            System.out.println("성공");

            String tokenInfo =TokenUtils.getUserIdFromJWT(token);
            System.out.println("토큰정보");
            System.out.println(token);
            return vo.getMg_auth();

        }else {
            //실패면 메세지 전달 및 리다이렉트
            System.out.println("실패");
            String msg = "로그인 실패 / 비밀번호를 확인하세요";
            return msg;
        }

//        System.out.println("id : " + id);
//        System.out.println("pw : " + pw);
//        System.out.println("auth : " + auth);

//        if(id.equals("admin")&&pw.equals("admin")){
//                return "관리자";
//        }else{
//            return "비밀번호를 확인하세요";
//        }
    }




}