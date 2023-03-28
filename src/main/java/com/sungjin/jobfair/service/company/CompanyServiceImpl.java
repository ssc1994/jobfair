package com.sungjin.jobfair.service.company;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    CompanyMapper companyMapper;


    //################## QnA Service #######################
    @Override
    public void cqnaRegist(QnAVO vo) {
        System.out.println(vo.toString());
        companyMapper.cqnaRegist(vo);
    }
    @Override
    public ArrayList<QnAVO> cgetQnAList(String com_num, Criteria cri) {
        return companyMapper.cgetQnAList(com_num, cri);
    }
    @Override
    public QnAVO getUserQnADetail(int qa_num) {
        return companyMapper.getUserQnADetail(qa_num);
    }
    @Override
    public UserVO cQnAInfo(String user_id) {
        return companyMapper.cQnAInfo(user_id);
    }
    @Override
    public QnAVO getQnAReply(int qa_num) {
        return companyMapper.getQnAReply(qa_num);
    }
    @Override
    public QnAVO getComQnADetail(int qa_num) {
        return companyMapper.getComQnADetail(qa_num);
    }


    //################## JobPost Service #######################
    @Override
    public int empRegist(EmpVO vo) {
        return companyMapper.empRegist(vo);
    }

    @Override
    public int empModify(EmpVO vo) {
        return companyMapper.empModify(vo);
    }

    @Override
    public EmpVO getEmpData(int jpl_num) {
        return companyMapper.getEmpData(jpl_num);
    }

    @Override
    public ArrayList<EmpVO> getComJobPosingList(Map paramMap) {
        return companyMapper.getComJobPosingList(paramMap);
    }

    @Override
    public ArrayList<EmpVO> getComEmpDesc(String com_num) {
        return companyMapper.getComEmpDesc(com_num);
    }

    @Override
    public ArrayList<Integer> getCountAppList(Map paramMap) {
        return companyMapper.getCountAppList(paramMap);
    }

    @Override
    public int getTotalJpl(String com_num) {
        return companyMapper.getTotalJpl(com_num);
    }

    @Override
    public int getTotalAl(String jpl_num) {
        return companyMapper.getTotalAl(jpl_num);
    }

    @Override
    public ArrayList<ApplyVO> getApplicantList(Map map) {
        return companyMapper.getApplicantList(map);
    }

    @Override
    public void chgApplicantState(Map map) {
        companyMapper.chgApplicantState(map);
    }

    //################## Login Service #######################
        //회사 번호를 가지고 회사정보 가져오기
    public CompanyVO info(String com_num) {
        return companyMapper.info(com_num);
    }



    //################## 페이지네이션 관련 Service #######################

//    @Override
//    public Map<String, Object> uQnAListAxios(Criteria cri) {
//        return userMapper.uQnAListAxios(cri);
//    }

    @Override
    public int cQnAGetTotal(Criteria cri, String com_num) {
        return companyMapper.cQnAGetTotal(cri, com_num);
    }

    //####################### 기업 메인 페이지 #######################
        //현황판( 진행 중, 지원마감, 열람, 미열람) 데이터 가져오기
    @Override
    public ArrayList<Integer> getStatusPosting(String com_num) {
        return companyMapper.getStatusPosting(com_num);
    }
        //현황판(열람, 미열람 이력서 수) 가져오기
    @Override
    public ArrayList<Integer> getStatusRes(String com_num) {
        return companyMapper.getStatusRes(com_num);
    }
        // 내가 등록한 최신공고
    @Override
    public ArrayList<EmpVO> getRecentPosting(String com_num){
        return companyMapper.getRecentPosting(com_num);
    }
        // 최근 지원자
    @Override
    public ArrayList<ApplyVO> getRecentApplicant(String com_num){
        return companyMapper.getRecentApplicant(com_num);
    }
}
