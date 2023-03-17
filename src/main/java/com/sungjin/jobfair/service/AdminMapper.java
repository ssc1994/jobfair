package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminMapper {

    //**********************************************채용공고**********************************************
    //모든 기업이 등록한 모든 채용공고 가져오기
    public ArrayList<EmpVO> getEmpData();

    public ArrayList<CompanyVO> getComData(String com_num);
}
