package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.ResumeVO;
import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    //로그인 확인
    public UserVO login(UserVO vo);
    //큐앤에이 등록
    public void qnaRegist(QnAVO vo);
    //Current User 정보 불러오기
    public UserVO info(String id);
    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList();
    //큐앤에이 기업 데이터 전달하기
//    public QnAVO uQnABtnClick(int jpl_num);

    //채용공고 목록 가져오기
    public ArrayList<EmpVO> getJobPostList();
    //채용공고 검색 목록 가져오기
    public ArrayList<EmpVO> getJobPostSrc(String str);
    
    
    //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo();

    //큐앤에이 상세페이지 데이터 가져오기
    public QnAVO getQnADetail(int qa_num);

    //큐앤에이 수정
    public int uQnAModi(QnAVO vo);

}