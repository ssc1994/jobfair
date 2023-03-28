package com.sungjin.jobfair.service.admin;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface AdminMapper {

    //################## 메인 #######################
    //회원정보에서 auth의 값이 2면 미승인기업 3이면 승인기업, 값을 가져와서 화면에 띄우기
    public ArrayList<UserVO> getAuth();

    //전체 채용정보가져오기(기업이랑 조인)
    public ArrayList<EmpVO> getAllData(String com_num);
    //전체채용정보 페이지네이션하기위해 리스트 가져오기
    public ArrayList<EmpVO> getEmpList(Criteria cri);

    //################## 통계 #######################
    //전체 유저정보 가져와서 통계에 남녀가입성비나타내기
    public ArrayList<UserVO> getUserInfo();

    //통계에 인기많은 채용공고 뿌리기
    public ArrayList<StatisticVO> getPopList();


    //큐앤에이
    //큐앤에이 등록
    public void aqnaRegist(QnAVO vo);

    //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> agetQnAList(@Param("cri") Criteria cri);

    //큐앤에이 디테일 정보 가져오기
    public QnAVO getQnADetail(int qa_num);

    //어드민 큐앤에이 디테일 정보 가져오기
    public QnAVO getAdmQnADetail(int qa_num);

    //큐앤에이 페이지네이션
    public int aQnAGetTotal(Criteria cri);

    //큐앤에이 삭제
    public void adeleteQnA(String qa_num);

}
