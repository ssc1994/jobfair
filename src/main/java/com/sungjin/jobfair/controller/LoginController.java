package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.TokenUtils;
import com.sungjin.jobfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jobfair")
public class LoginController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping(value = "/login")
    public UserVO login(@RequestBody Map<String,String> param, Model model){

        // 입력받은 아이디 / 비밀번호 / auth
        String id = param.get("user_id");
        String pw = param.get("user_pw");
        String auth = param.get("mg_auth");

        System.out.println(id);
        System.out.println(pw);
        System.out.println(auth);

        //서비스 영역으로 보내서 db와 확인하기
        UserVO tempVO = UserVO.builder().user_id(id).user_pw(pw).mg_auth(auth).build();

        //받은 데이터를 vo로 만들어서 보냄
        UserVO vo = userService.login(tempVO);

        //서비스 영역에서 확인후 성공이라면 session생성
        System.out.println("서버에서 검색결과");
        System.out.println(vo);


        if(vo!=null){

            //토큰 보류
            /*//세션에 넣을 jwt 생성
            String token = TokenUtils.generateToken(vo);
            System.out.println("token :" +token);
            System.out.println("성공");

            String tokenInfo =TokenUtils.getUserIdFromJWT(token);
            System.out.println("토큰정보");
            System.out.println(token);*/

            return vo;


        }else {
            //실패면 메세지 전달 및 리다이렉트
            System.out.println("실패");
            String msg = "로그인 실패 / 비밀번호를 확인하세요";
            model.addAttribute("msg",msg);
        return null;
        }
    }

    @PostMapping(value = "/userInfo")
    public Map<String, String> userInfo(@RequestBody Map<String,String> param){
        String id = param.get("user_id");
        UserVO vo =  userService.info(id);
        System.out.println(vo);
        Map<String, String> map = new HashMap<>();
        map.put("user_name",vo.getUser_name());
        map.put("user_email",vo.getUser_email());
        map.put("user_phone",vo.getUser_phone());

        map.put("com_num",vo.getCom_num());


        return map;
    }




}