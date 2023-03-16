package com.sungjin.jobfair.userInfoModiService;

import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userModiService")
public class UserModiServiceImpl implements UserModiService {

    @Autowired
    public UserModiMapper userModiMapper;

    //user 정보 조회
    @Override
    public UserVO getUserInfo(UserVO vo) {
        return userModiMapper.getUserInfo(vo);
    }
}