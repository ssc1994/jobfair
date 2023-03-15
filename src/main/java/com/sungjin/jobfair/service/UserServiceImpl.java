package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public UserVO login(UserVO vo) {
        return userMapper.login(vo);
    }

    @Override
    public void qnaRegist(QnAVO vo) {
        System.out.println(vo.toString());
        userMapper.qnaRegist(vo);
    }

    @Override
    public ArrayList<QnAVO> getQnAList() {
        return userMapper.getQnAList();
    }
    @Override
    public UserVO info(String id) {
        return userMapper.info(id);

    }

    @Override
    public QnAVO getQnADetail(int qa_num) {
        return userMapper.getQnADetail(qa_num);
    }
}