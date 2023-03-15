package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.UserVO;
import org.springframework.context.annotation.Primary;


public interface CompanyService {

    public int empRegist(EmpVO vo);

    public CompanyVO info(String com_num);

    public EmpVO getEmpData(int jpl_num);



}
