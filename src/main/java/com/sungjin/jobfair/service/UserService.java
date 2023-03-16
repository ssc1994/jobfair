package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.ResumeVO;
import com.sungjin.jobfair.command.UserVO;

import java.util.ArrayList;

public interface UserService {

    //################## Login Service #######################
    public UserVO login(UserVO vo);
    public UserVO info(String id);


    //################## QnA Service #######################
    //큐앤에이 답변 등록
    public void qnaRegist(QnAVO vo);
    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList();
    //큐앤에이 상세페이지 데이터 가져오기
    public QnAVO getQnADetail(int qa_num);
    //큐앤에이 수정
    public int uQnAModi(QnAVO vo);

    //큐앤에이 기업 데이터 전달하기
//    public QnAVO uQnABtnClick(int jpl_num);


    //################## jobPost Service #######################
    //채용공고 목록 가져오기
    public ArrayList<EmpVO> getJobPostList();
    //채용공고 검색 목록 가져오기
    public ArrayList<EmpVO> getJobPostSrc(String str);

    //################## Resume Service #######################
    //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo();
}