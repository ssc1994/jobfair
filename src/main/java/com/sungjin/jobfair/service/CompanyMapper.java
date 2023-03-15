package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface CompanyMapper {

    public int empRegist(EmpVO vo);


    public CompanyVO info(String com_num);


    public EmpVO getEmpData(int jpl_num);



}
