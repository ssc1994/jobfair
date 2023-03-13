package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface CompanyMapper {

    public int empRegist(EmpVO vo);



}
