package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.userInfoModiService.UserModiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobfair/userInfoModi")
public class UserInfoModiController {

    @Autowired
    @Qualifier("userModiService")
    public UserModiService userModiService;

    // 개인정보 수정 모달 창 띄울 때 기존 회원 정보 가져와서 뿌려주기 위한 요청.
    @PostMapping("getUserInfo")
    public UserVO getUserInfo (@RequestBody UserVO uv) {
//        System.out.println(uv.getUser_id());
        UserVO userInfo = userModiService.getUserInfo(uv);
//        System.out.println(userInfo.toString());
        return userInfo;
    }

    @PostMapping("modifyInfo")
    public void modifyInfo (@RequestBody UserVO uv) {

        System.out.println(uv.toString());


    }


}
