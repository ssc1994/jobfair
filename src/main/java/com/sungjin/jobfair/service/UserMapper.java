package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    //로그인 확인
    public UserVO login(UserVO vo);
    //큐앤에이 등록
    public void qnaRegist(QnAVO vo);
    //Current User 정보 불러오기
    public UserVO info(String id);
    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList();

}