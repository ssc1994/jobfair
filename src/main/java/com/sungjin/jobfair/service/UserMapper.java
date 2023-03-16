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

    //로그인 요청시 비밀번호 확인 위해, db에 암호화된 pw 가져오기
    public String getEncodePw(UserVO vo);
    //로그인 확인
    public UserVO login(UserVO vo);
    //큐앤에이 등록
    public void qnaRegist(QnAVO vo);
    //Current User 정보 불러오기
    public UserVO info(String id);
    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList();

    //채용공고 목록 가져오기
    public ArrayList<EmpVO> getJobPostList();
    //채용공고 검색 목록 가져오기
    public ArrayList<EmpVO> getJobPostSrc(String str);
    
    
    //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo();

    //큐앤에이 상세페이지 데이터 가져오기
    public QnAVO getQnADetail(int qa_num);

}