package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //로그인 확인
    public UserVO login(UserVO vo);




}