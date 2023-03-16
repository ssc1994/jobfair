package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.ResumeVO;
import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //################## Login Service #######################
    @Override
    public UserVO login(UserVO vo) {
        return userMapper.login(vo);
    }
    @Override
    public UserVO info(String id) {
        return userMapper.info(id);
    }


    //################## QnA Service #######################
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
    public QnAVO getQnADetail(int qa_num) {
        return userMapper.getQnADetail(qa_num);
    }


    //################## jobPost Service #######################
    @Override
    public ArrayList<EmpVO> getJobPostList() {
        return userMapper.getJobPostList();
    }
    @Override
    public ArrayList<EmpVO> getJobPostSrc(String str) {
        return userMapper.getJobPostSrc(str);
    }


    //################## Resume Service #######################
    @Override
    public ArrayList<ResumeVO> resumeInfo() {
        return userMapper.resumeInfo();
    }



}