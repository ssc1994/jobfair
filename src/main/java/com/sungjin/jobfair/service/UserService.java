package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
import org.springframework.stereotype.Service;

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

    //################## jobPost Service #######################
    //채용공고 목록 가져오기
    public ArrayList<EmpVO> getJobPostList();
    //채용공고 검색 목록 가져오기
    public ArrayList<EmpVO> getJobPostSrc(String str);
    //기업이 입력한 채용공고 내용 유저의 채용공고 상세페이지에 뿌리기 (박희진 작성중)
//    public ArrayList<EmpVO> EmpRegistInfo();

    //################## Resume Service #######################
    //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo();

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