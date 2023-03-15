package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
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

    @Override
    public CompanyVO info(String com_num) {
        return companyMapper.info(com_num);
    }

    @Override
    public EmpVO getEmpData(int jpl_num) {
        return companyMapper.getEmpData(jpl_num);
    }
}
