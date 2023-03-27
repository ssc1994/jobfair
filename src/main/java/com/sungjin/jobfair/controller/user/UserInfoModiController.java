package com.sungjin.jobfair.controller.user;

import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.user.UserModiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 회원 정보 수정 컨트롤러
@RestController
@RequestMapping("/jobfair/userInfoModi")
public class UserInfoModiController {

    @Autowired
    @Qualifier("userModiService")
    public UserModiService userModiService;

    // 개인정보 수정 모달 창 띄울 때 기존 회원 정보 가져와서 뿌려주기 위한 요청.
    @PostMapping("getUserInfo")
    public UserVO getUserInfo (@RequestBody UserVO uv) {
        UserVO userInfo = userModiService.getUserInfo(uv);
        return userInfo;
    }

    //회원정보 변경
    @PostMapping("modifyInfo")
    public void modifyInfo (@RequestBody UserVO uv) {

        userModiService.modifyInfo(uv);

    }

    //비밀번호 변경
    @PostMapping("modifyPw")
    public String modifyPw (@RequestBody UserVO uv){

        return userModiService.modifyPw(uv);

    }


}