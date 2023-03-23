package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.pagination.Criteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;


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
    ArrayList<EmpVO> getComJobPosingList(String com_num);


    //################## Login Service #######################
    public CompanyVO info(String com_num);


    //####################### 페이지네이션 #######################

//    public Map<String, Object> uQnAListAxios(Criteria cri);

    public int cQnAGetTotal(Criteria cri, String com_num);

}
