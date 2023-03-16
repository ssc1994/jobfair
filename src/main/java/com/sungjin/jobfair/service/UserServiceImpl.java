package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder pwEncoder;

    //################## Login Service #######################
    @Override
    public UserVO login(UserVO vo) {

        //DB에서 암호화 된 비밀번호 가져와서 입력된 비밀번호랑 비교
        String rawPw = vo.getUser_pw(); //입력된 pw
        String encodePw = userMapper.getEncodePw(vo); //db에 저장된 암호화된 pw

        if(true == pwEncoder.matches(rawPw, encodePw)){
            return userMapper.login(vo);
        } else {
            return null;
        }

    }
    @Override
    public UserVO info(String id) {
        return userMapper.info(id);
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
    public int uQnAModi(QnAVO vo) {
        return userMapper.uQnAModi(vo);
    }
    @Override
    public void regResume(ResumeVO resVO) {
        userMapper.regResume(resVO);
    }

//    @Override
//    public QnAVO uQnABtnClick(int jpl_num) {
//        return userMapper.uQnABtnClick(jpl_num);
//    }


    //################## jobPost Service #######################
    @Override
    public void regResEdu(EduVO eduVO) {
        userMapper.regResEdu(eduVO);
    }

    @Override
    public void regResWe(WeVO weVO) {
        userMapper.regResWe(weVO);
    }
    
    @Override
    public void regResCert(CertVO certVO) {
        userMapper.regResCert(certVO);
    }

    //박희진 작성중
//    @Override
//    public ArrayList<EmpVO> EmpRegistInfo() {
//        return userMapper.EmpRegistInfo();
//    }

    //################## Resume Service #######################
    @Override
    public ArrayList<ResumeVO> resumeInfo() {
        return userMapper.resumeInfo();
    }
    
    @Override
    public void deleteResume(int res_num) {
        userMapper.deleteResume(res_num);
    }
}