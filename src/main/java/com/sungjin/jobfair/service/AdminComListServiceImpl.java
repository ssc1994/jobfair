package com.sungjin.jobfair.service;

import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminComListService")
public class AdminComListServiceImpl implements AdminComListService{

    @Autowired
    public AdminComListMapper adminComListMapper;

    //참여 업체 목록 가져오기
    @Override
    public List<CompanyVO> getComList(AdminComListCriteria cri) {
        List<CompanyVO> list = adminComListMapper.getComList(cri);
        return list;
    }

    //정렬 조건에 따른 참여 업체 목록 total 값 가져오기
    @Override
    public int getTotal(AdminComListCriteria cri) {
        return adminComListMapper.getTotal(cri);
    }

    //기업가입 승인,반려 처리
    public void handleApplication(UserVO uv){
        adminComListMapper.handleApplication(uv);
    };
}
