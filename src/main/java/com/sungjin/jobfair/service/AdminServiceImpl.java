package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.pagination.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;


//################## JobPost Service #######################
    @Override
    public ArrayList<EmpVO> getEmpData() {

        return adminMapper.getEmpData();
    }

    @Override
    public ArrayList<CompanyVO> getComData(String com_num) {
        return adminMapper.getComData(com_num);
    }

    //큐앤에이

    @Override
    public ArrayList<QnAVO> agetQnAList(Criteria cri) {
        return adminMapper.agetQnAList(cri);
    }

    //큐앤에이 페이지네이션
    @Override
    public int aQnAGetTotal(Criteria cri) {
        return adminMapper.aQnAGetTotal(cri);
    }
}
