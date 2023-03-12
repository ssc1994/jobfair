package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    CompanyMapper companyMapper;


    @Override
    public int empRegist(EmpVO vo) {
        return companyMapper.empRegist(vo);
    }
}
