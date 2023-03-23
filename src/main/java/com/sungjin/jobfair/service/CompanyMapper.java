package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.pagination.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CompanyMapper {

    public int empRegist(EmpVO vo);
    //큐앤에이 답변 등록
    public void cqnaRegist(QnAVO vo);
    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> cgetQnAList(String com_num, Criteria cri);
    //큐앤에이 상세페이지 데이터 가져오기 - 유저꺼
    public QnAVO getUserQnADetail(int qa_num);
    //큐앤에이 상세페이지 데이터 가져오기 - 기업꺼
    public UserVO cQnAInfo(String user_id);

    public QnAVO getQnAReply(int qa_num);
    

    public CompanyVO info(String com_num);


    public EmpVO getEmpData(int jpl_num);


    //기업 큐앤에이 디테일 정보 가져오기
    public QnAVO getComQnADetail(int qa_num);
    
    //기업이 등록한 채용공고 목록 가져오기
    ArrayList<EmpVO> getComJobPosingList(String com_num);



    //####################### 페이지네이션 #######################

//    public Map<String, Object> uQnAListAxios(Criteria cri);

    public int cQnAGetTotal(Criteria cri, String com_num);


}
