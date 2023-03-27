package com.sungjin.jobfair.service.company;

import com.sungjin.jobfair.command.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMypageMapper {

    //해당기업의 테이블에 새로 업로드된 로고(이미지)파일 정보로 수정하기
    public void modiLogo(CompanyVO cv);
    //로그인 중인 기업의 정보 가져오기
    public CompanyVO getComInfo(String com_num);

    //기업 정보 수정
    public void modifyComInfo(CompanyVO cv);
}
