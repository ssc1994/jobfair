package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    CompanyMapper companyMapper;


    @Override
    public int empRegist(EmpVO vo) {
        return companyMapper.empRegist(vo);
    }

    @Override
    public void cqnaRegist(QnAVO vo) {
        System.out.println(vo.toString());
        companyMapper.cqnaRegist(vo);
    }

    @Override
    public ArrayList<QnAVO> cgetQnAList() {
        return companyMapper.cgetQnAList();
    }

    @Override
    public QnAVO getUserQnADetail(int qa_num) {
        return companyMapper.getUserQnADetail(qa_num);
    }

    @Override
    public UserVO getComQnADetail(String user_id) {
        return companyMapper.getComQnADetail(user_id);
    }

    @Override
    public QnAVO getQnAReply(int qa_num) {
        return companyMapper.getQnAReply(qa_num);
    }




}
