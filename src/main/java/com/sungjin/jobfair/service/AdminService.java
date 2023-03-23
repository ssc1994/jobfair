package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.pagination.Criteria;

import java.util.ArrayList;
import java.util.Map;

public interface AdminService {

    //**********************************************채용공고**********************************************
    public ArrayList<EmpVO> getEmpData();
//    기업 정보가져오기
    public ArrayList<CompanyVO> getComData(String com_num);

    //기업이랑 채용정보 조인해서 가져오기


    //큐앤에이

    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> agetQnAList(Criteria cri);

    //큐앤에이 페이지네이션
    public int aQnAGetTotal(Criteria cri);

}
