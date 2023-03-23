package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public interface UserService {

    //################## 로그인 관련(login) Service #######################
    public UserVO login(UserVO vo);
    public UserVO info(String id);


    //################## QnA 관련 Service #######################
        //큐앤에이 답변 등록
    public void qnaRegist(QnAVO vo);
        //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList(Criteria cri);
        //큐앤에이 상세페이지 데이터 가져오기
    public QnAVO getQnADetail(int qa_num);
        //큐앤에이 수정
    public int uQnAModi(QnAVO vo);
        //큐앤에이 기업 데이터 전달하기
//    public QnAVO uQnABtnClick();


    //################## 채용공고(jobPost) 관련 Service #######################
        //채용공고 목록 가져오기
    public ArrayList<EmpVO> getJobPostList();
        //채용공고 검색 목록 가져오기
    public ArrayList<EmpVO> getJobPostSrc(EmpSearchVO vo);
        //기업이 입력한 채용공고 내용 유저의 채용공고 상세페이지에 뿌리기 (박희진 작성중)
//    public ArrayList<EmpVO> EmpRegistInfo();
        // 유저가 지원한 공고인지 찾기
        public int EmpApplied(String user_id, String jpl_num);

    //채용공고 지원하기
    public void EmpApply(String user_id, String jpl_num, String res_num);


    //################## 마이페이지(MyPage) Service #######################
        //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo(String user_id);
        //이력서 삭제버튼 누르면 데이터 삭제하기
    public void deleteResume(String res_num);

    public void deleteEdu(String res_num);

    public void deleteWe(String res_num);

    public void deleteCert(String res_num);


    //################## 이력서(Resume) 관련 Service #######################
        // 이력서 등록
        // 1) 이력서 -인적사항- 등록
    public void regResume(ResumeVO resVO);
        // 2) 이력서 -학력- 등록
    public void regResEdu(EduVO eduVO);
        // 3) 이력서 -경력- 등록
    public void regResWe(WeVO weVO);
        // 4) 이력서 -자격증- 등록
    public void regResCert(CertVO certVO);

        // 이력서 상세페이지
        // 1) 이력서 상세 가져오기
    public ResumeVO getResDetail(String res_num);
        // 2) 이력서 학력 가져오기
    public ArrayList<EduVO> getEduDetail(String res_num);
        // 3) 이력서 경력 가져오기
    public ArrayList<WeVO> getWeDetail(String res_num);
        // 4) 이력서 자격증 가져오기
    public ArrayList<CertVO> getCertDetail(String res_num);

        // 이력서 수정
    // 1) 이력서 -인적사항- 수정
    public void modiResume(ResumeVO resVO);
    // 2) 이력서 -학력- 수정
    public void modiResEdu(EduVO eduVO);
    // 3) 이력서 -경력- 수정
    public void modiResWe(WeVO weVO);
    // 4) 이력서 -자격증- 수정
    public void modiResCert(CertVO certVO);


    //####################### 페이지네이션 #######################
    //페이지 처리
//    public ArrayList<QnAVO> getPage(Criteria cri);

    //전체 게시글 가져오기
//    public int getQnATotal();


    //페이지네이션
//    public Map<String, Object> uQnAListAxios(Criteria cri);

    public int uQnAGetTotal(Criteria cri);

}