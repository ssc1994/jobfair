package com.sungjin.jobfair.service;

import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;

import java.util.List;

public interface AdminComListService {
    //정렬 조건에 따른 참여 업체 목록(한페이지당 몇개씩) 가져오기
    public List<CompanyVO> getComList(AdminComListCriteria cri);

    //정렬 조건에 따른 참여 업체 목록 total 값 가져오기
    int getTotal(AdminComListCriteria cri);



}
