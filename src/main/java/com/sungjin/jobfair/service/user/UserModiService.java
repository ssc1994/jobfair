package com.sungjin.jobfair.service.user;

import com.sungjin.jobfair.command.UserVO;

public interface UserModiService {

    //user 정보 조회
    public UserVO getUserInfo(UserVO vo);

    //회원정보 변경
    public void modifyInfo(UserVO vo);

    //비밀번호 변경 요청
    public String modifyPw(UserVO vo);


}
