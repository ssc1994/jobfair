package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMypageMapper {

    //해당기업의 테이블에 새로 업로드된 로고(이미지)파일 정보로 수정하기
    public void modiLogo(CompanyVO cv);

}
