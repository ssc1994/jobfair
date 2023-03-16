package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
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
    //기업이 입력한 채용공고 내용 유저의 채용공고 상세페이지에 뿌리기 (박희진 작성중)
//    public ArrayList<EmpVO> EmpRegistInfo();
    
    
    //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo();

    //큐앤에이 상세페이지 데이터 가져오기
    public QnAVO getQnADetail(int qa_num);

    //큐앤에이 수정
    public int uQnAModi(QnAVO vo);

    //################## MyPage Service #######################
    //이력서 삭제버튼 누르면 데이터 삭제하기
    public void deleteResume(int res_num);
    
    //이력서 등록
        // 1) 이력서 -인적사항- 등록
    public void regResume(ResumeVO resVO);
        // 2) 이력서 -학력- 등록
    public void regResEdu(EduVO eduVO);
        // 3) 이력서 -경력- 등록
    public void regResWe(WeVO weVO);
        // 4) 이력서 -자격증- 등록
    public void regResCert(CertVO certVO);

}