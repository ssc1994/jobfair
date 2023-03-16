package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CompanyMapper {

    public int empRegist(EmpVO vo);
    //큐앤에이 답변 등록
    public void cqnaRegist(QnAVO vo);
    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> cgetQnAList();
    //큐앤에이 상세페이지 데이터 가져오기 - 유저꺼
    public QnAVO getUserQnADetail(int qa_num);
    //큐앤에이 상세페이지 데이터 가져오기 - 기업꺼
    public UserVO getComQnADetail(String user_id);

    public QnAVO getQnAReply(int qa_num);


    public CompanyVO info(String com_num);


    public EmpVO getEmpData(int jpl_num);



}
