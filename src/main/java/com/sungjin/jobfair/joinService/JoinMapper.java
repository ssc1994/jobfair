package com.sungjin.jobfair.joinService;

import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {
    //중복 아이디 확인 기능
    public int checkSameId(UserVO vo);

    //회원가입 기능
    public int uJoin(UserVO vo);
}

