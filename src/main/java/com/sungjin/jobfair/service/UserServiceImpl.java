package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
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

    //################## 로그인 관련(login) Service #######################
    @Override
    public UserVO login(UserVO vo) {
//        //DB에서 암호화 된 비밀번호 가져와서 입력된 비밀번호랑 비교
//        String rawPw = vo.getUser_pw(); //입력된 pw
//        String encodePw = userMapper.getEncodePw(vo); //db에 저장된 암호화된 pw
//
//        if(true == pwEncoder.matches(rawPw, encodePw)){
//            return userMapper.login(vo);
//        } else {
//            return null;
//        }
            return userMapper.login(vo);

    }
    @Override
    public UserVO info(String id) {
        return userMapper.info(id);
    }


    //################## QnA 관련 Service #######################
    @Override
    public void qnaRegist(QnAVO vo) {
        System.out.println(vo.toString());
        userMapper.qnaRegist(vo);
    }
    @Override
    public ArrayList<QnAVO> getQnAList(Criteria cri) {
        return userMapper.getQnAList(cri);
    }
    @Override
    public QnAVO getQnADetail(int qa_num) {
        return userMapper.getQnADetail(qa_num);
    }
    @Override
    public int uQnAModi(QnAVO vo) {
        return userMapper.uQnAModi(vo);
    }
//    @Override
//    public QnAVO uQnABtnClick() {
//        return userMapper.uQnABtnClick();
//    }

    //################## 채용공고(jobPost) 관련 Service #######################
    @Override
    public ArrayList<EmpVO> getJobPostList() {
        return userMapper.getJobPostList();
    }
    @Override
    public ArrayList<EmpVO> getJobPostSrc(EmpSearchVO vo) {
        return userMapper.getJobPostSrc(vo);
    }

    @Override
    public int EmpApplied(String user_id, String jpl_num){
        return userMapper.EmpApplied(user_id, jpl_num);
    }
    @Override
    public void EmpApply(String user_id, String jpl_num, String res_num){
        userMapper.EmpApply(user_id, jpl_num, res_num);
    }
    
    //박희진 작성중
//    @Override
//    public ArrayList<EmpVO> EmpRegistInfo() {
//        return userMapper.EmpRegistInfo();
//    }

    //################## 마이페이지(MyPage) Service #######################
    @Override
    public ArrayList<ResumeVO> resumeInfo(String user_id) {
        return userMapper.resumeInfo(user_id);
    }
    @Override
    public void deleteResume(int res_num) {
        userMapper.deleteResume(res_num);
    }

    //################## 이력서(Resume) 관련 Service #######################
    @Override
    public void regResume(ResumeVO resVO) {
        userMapper.regResume(resVO);
    }
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




    //################## 페이지네이션 관련 Service #######################
//    @Override
//    public ArrayList<QnAVO> getPage(Criteria cri) {
//
//        ArrayList<QnAVO> list = userMapper.getPage(cri);
//        return list;
//    }
//    @Override
//    public int getQnATotal() {
//        return userMapper.getQnATotal();
//    }



    //페이지네이션
//    @Override
//    public Map<String, Object> uQnAListAxios(Criteria cri) {
//        return userMapper.uQnAListAxios(cri);
//    }

    @Override
    public int uQnAGetTotal(Criteria cri) {
        return userMapper.uQnAGetTotal(cri);
    }



}