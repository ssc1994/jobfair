package com.sungjin.jobfair.joinService;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JoinMapper {
    //중복 아이디 확인 기능
    public int checkSameId(UserVO vo);

    //회원가입 정보 등록
    public int uJoin(UserVO vo);

    //기업가입 정보 등록
    public int cJoin(CompanyVO vo);

    //기업가입시 기업테이블의 com_num을 user 테이블의 com_num에 넣어주기.
    public int insertComNum(UserVO vo);

}

