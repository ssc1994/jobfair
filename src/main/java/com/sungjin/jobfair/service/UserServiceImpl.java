package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements UserService {

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
    public ArrayList<ResumeVO> resumeInfo() {
        return userMapper.resumeInfo();
    }

    @Override
    public QnAVO getQnADetail(int qa_num) {
        return userMapper.getQnADetail(qa_num);
    }
    @Override
    public ArrayList<EmpVO> getJobPostList() {
        return userMapper.getJobPostList();
    }
    @Override
    public ArrayList<EmpVO> getJobPostSrc(EmpSearchVO vo) {
        return userMapper.getJobPostSrc(vo);
    }

}