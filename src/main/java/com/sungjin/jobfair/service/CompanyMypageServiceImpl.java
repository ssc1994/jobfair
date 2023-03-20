package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("comMypageService")
public class CompanyMypageServiceImpl implements  CompanyMypageService{

    @Autowired
    public CompanyMypageMapper comMypageMapper;

    //해당기업의 테이블에 새로 업로드된 로고(이미지)파일 정보로 수정하기
    @Override
    public void modiLogo(CompanyVO cv) {
        comMypageMapper.modiLogo(cv);
    }
}
