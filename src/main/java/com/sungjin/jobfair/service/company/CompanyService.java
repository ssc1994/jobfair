package com.sungjin.jobfair.service.company;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Map;


public interface CompanyService {

    //################## QnA Service #######################
        //큐앤에이 답변 등록
    public void cqnaRegist(QnAVO vo);
        //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> cgetQnAList(String com_num, @Param("cri") Criteria cri);
        //큐앤에이 상세페이지 데이터 가져오기 - 유저꺼
    public QnAVO getUserQnADetail(int qa_num);
        //큐앤에이 상세페이지 데이터 가져오기 - 기업꺼
    public UserVO cQnAInfo(String user_id);
        //기업 큐앤에이 디테일 정보 가져오기
    public QnAVO getComQnADetail(int qa_num);
        //기업 큐앤에이 댓글
    public QnAVO getQnAReply(int qa_num);


    //################## JobPost Service #######################
    //채용공고 등록하기
    public int empRegist(EmpVO vo);
    //채용공고 등록하기
    public int empModify(EmpVO vo);
    //채용공고 페이지에서 입력한 값 가져오기??
    public EmpVO getEmpData(int jpl_num);
        //기업이 등록한 채용공고 목록 가져오기
    ArrayList<EmpVO> getComJobPosingList(Map paramMap);

    //기업이 등록한 가장 최근 최용공고 불러오기
    ArrayList<EmpVO> getComEmpDesc(String com_num);

    ArrayList<Integer> getCountAppList(Map paramMap);
        //채용공고 목록 total 가져오기
    int getTotalJpl(String com_num);
        //지원자 리스트 total 가져오기
    int getTotalAl(String jpl_num);
        // 채용공고에 지원한 지원자 리스트 가져오기
    ArrayList<ApplyVO> getApplicantList(Map map);
        // 이력서 열람/미열람 상태 변경
    void chgApplicantState(Map map);


    //################## Login Service #######################
    public CompanyVO info(String com_num);


    //####################### 페이지네이션 #######################

//    public Map<String, Object> uQnAListAxios(Criteria cri);

    public int cQnAGetTotal(Criteria cri, String com_num);

    //####################### 기업 메인 페이지 #######################
        //현황판( 진행 중, 지원마감, 열람, 미열람) 데이터 가져오기
    ArrayList<Integer> getStatusPosting(String com_num);
        //현황판(열람, 미열람 이력서 수) 가져오기
    ArrayList<Integer> getStatusRes(String com_num);
        // 내가 등록한 최신공고
    ArrayList<EmpVO> getRecentPosting(String com_num);
        // 최근 지원자
    ArrayList<ApplyVO> getRecentApplicant(String com_num);

}
