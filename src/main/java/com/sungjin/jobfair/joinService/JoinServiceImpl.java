package com.sungjin.jobfair.joinService;

import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("joinService")
public class JoinServiceImpl implements JoinService{

    @Autowired
    private JoinMapper joinMapper;

    @Override
    public int checkSameId(UserVO vo) {
        return joinMapper.checkSameId(vo);
    }

    @Override
    public int uJoin(UserVO vo) {
        return joinMapper.uJoin(vo); //insert 한 행의 수를 반환 해줌.
    }
}