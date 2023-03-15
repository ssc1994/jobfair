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

    @PostMapping("getUserInfo")
    public UserVO getUserInfo (@RequestBody UserVO uv) {
        System.out.println(uv.getUser_id());
        UserVO userInfo = userModiService.getUserInfo(uv);
        System.out.println(userInfo.toString());
        return userInfo;
    }




}
