package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import org.springframework.context.annotation.Primary;


public interface CompanyService {

    public int empRegist(EmpVO vo);


}
