package com.sungjin.jobfair.service;

import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;

import java.util.List;

public interface AdminComListService {
    //참여 업체 목록 가져오기
    public List<CompanyVO> getComList(AdminComListCriteria cri);



}
