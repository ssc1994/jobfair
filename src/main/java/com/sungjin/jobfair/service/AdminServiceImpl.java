package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    //################## 메인 #######################
    @Override
    public ArrayList<UserVO> getAuth() {
        return adminMapper.getAuth();
    }

    //전체채용정보 가쟈오기 기업이랑 조인해서 채용정보를 작성한 기업의 정보도 출력하기
    @Override
    public ArrayList<EmpVO> getAllData(String com_num) {
        return adminMapper.getAllData(com_num);
    }

    @Override
    public ArrayList<EmpVO> getEmpList(Criteria cri) {
        return adminMapper.getEmpList(cri);
    }

    //################## 통계 #######################
    @Override
    public ArrayList<UserVO> getUserInfo() {
        return adminMapper.getUserInfo();
    }

    @Override
    public ArrayList<StatisticVO> getPopList() {
        return adminMapper.getPopList();
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
