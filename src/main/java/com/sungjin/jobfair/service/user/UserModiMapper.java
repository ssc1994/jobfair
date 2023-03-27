package com.sungjin.jobfair.service.user;

import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserModiMapper {

    //user 정보 조회
    public UserVO getUserInfo(UserVO vo);

    //회원정보 변경
    public void modifyInfo(UserVO vo);

    //접속한 유저의 현재 비밀번호 가져오기
    public String getEncodePw(UserVO vo);

    //새로운 비밀번호로 변경
    public void modifyPw(UserVO vo);

}
