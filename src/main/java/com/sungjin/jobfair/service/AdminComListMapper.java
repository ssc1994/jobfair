package com.sungjin.jobfair.service;

import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminComListMapper {
    //참여 업체 목록 가져오기
    public List<CompanyVO> getComList(@Param("cri") AdminComListCriteria cri);

    //정렬 조건에 따른 참여 업체 목록 total 값 가져오기
    int getTotal(@Param("cri") AdminComListCriteria cri);
}
