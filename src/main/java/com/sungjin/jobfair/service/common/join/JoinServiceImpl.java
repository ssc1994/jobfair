package com.sungjin.jobfair.service.common.join;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("joinService")
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinMapper joinMapper;

    //중복 아이디 확인 기능
    @Override
    public int checkSameId(UserVO vo) {
        return joinMapper.checkSameId(vo);
    }

    //회원가입 정보 등록
    @Override
    public int uJoin(UserVO vo) {
        return joinMapper.uJoin(vo); //insert 한 행의 수를 반환 해줌.
    }

    //기업가입 정보 등록
    @Override
    public int cJoin(CompanyVO vo) {
        return joinMapper.cJoin(vo); //insert 한 행의 수를 반환해줌
    }

    //기업가입시 기업테이블의 com_num을 user 테이블의 com_num에 넣어주기.
    @Override
    public int insertComNum(UserVO vo) {
        return joinMapper.insertComNum(vo);
    }
}