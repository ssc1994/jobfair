package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.pagination.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface AdminMapper {

    //**********************************************채용공고**********************************************
    //모든 기업이 등록한 모든 채용공고 가져오기
    public ArrayList<EmpVO> getEmpData();

    public ArrayList<CompanyVO> getComData(String com_num);


    //큐앤에이

    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> agetQnAList(@Param("cri") Criteria cri);

    //큐앤에이 페이지네이션

    public int aQnAGetTotal(Criteria cri);
}
