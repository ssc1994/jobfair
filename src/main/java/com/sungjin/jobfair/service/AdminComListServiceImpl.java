package com.sungjin.jobfair.service;

import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;
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
}
