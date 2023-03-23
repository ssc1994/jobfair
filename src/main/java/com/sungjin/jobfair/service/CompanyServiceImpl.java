package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
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


    //################## QnA Service #######################
    @Override
    public void cqnaRegist(QnAVO vo) {
        System.out.println(vo.toString());
        companyMapper.cqnaRegist(vo);
    }
    @Override
    public ArrayList<QnAVO> cgetQnAList(String com_num) {
        return companyMapper.cgetQnAList(com_num);
    }
    @Override
    public QnAVO getUserQnADetail(int qa_num) {
        return companyMapper.getUserQnADetail(qa_num);
    }
    @Override
    public UserVO cQnAInfo(String user_id) {
        return companyMapper.cQnAInfo(user_id);
    }
    @Override
    public QnAVO getQnAReply(int qa_num) {
        return companyMapper.getQnAReply(qa_num);
    }
    @Override
    public QnAVO getComQnADetail(int qa_num) {
        return companyMapper.getComQnADetail(qa_num);
    }


    //################## JobPost Service #######################
    @Override
    public int empRegist(EmpVO vo) {
        return companyMapper.empRegist(vo);
    }

    @Override
    public int empModify(EmpVO vo) {
        return companyMapper.empModify(vo);
    }

    @Override
    public EmpVO getEmpData(int jpl_num) {
        return companyMapper.getEmpData(jpl_num);
    }

    @Override
    public ArrayList<EmpVO> getComJobPosingList(String com_num) {
        return companyMapper.getComJobPosingList(com_num);
    }

    //################## Login Service #######################
        //회사 번호를 가지고 회사정보 가져오기
    public CompanyVO info(String com_num) {
        return companyMapper.info(com_num);
    }
}
