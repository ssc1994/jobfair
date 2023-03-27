package com.sungjin.jobfair.service.admin;

import com.sungjin.jobfair.pagination.adminComList.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminComListMapper {
    //참여 업체 목록 가져오기
    public List<CompanyVO> getComList(@Param("cri") AdminComListCriteria cri);

    //정렬 조건에 따른 참여 업체 목록 total 값 가져오기
    int getTotal(@Param("cri") AdminComListCriteria cri);

    //기업가입 승인,반려 처리
    public void handleApplication(UserVO uv);
}
