package com.sungjin.jobfair.userInfoModiService;

import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserModiMapper {

    //user 정보 조회
    public UserVO getUserInfo(UserVO vo);

}
