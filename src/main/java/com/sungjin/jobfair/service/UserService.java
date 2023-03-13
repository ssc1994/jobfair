package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;

import java.util.ArrayList;

public interface UserService {
    public UserVO login(UserVO vo);

    //큐앤에이 등록
    public void qnaRegist(QnAVO vo);

    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList();

}