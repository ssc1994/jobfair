package com.sungjin.jobfair.service.user;

import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.empSrc.EmpSrcCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    //################## Login Service #######################
        //로그인 요청시 비밀번호 확인 위해, db에 암호화된 pw 가져오기
    public String getEncodePw(UserVO vo);
        //로그인 확인
    public UserVO login(UserVO vo);
        //Current User 정보 불러오기
    public UserVO info(String id);


    //################## QnA Service #######################
        //큐앤에이 등록
    public void qnaRegist(QnAVO vo);
        //큐앤에이 목록 가져오기
    public ArrayList<QnAVO> getQnAList(@Param("cri") Criteria cri);
        //큐앤에이 상세페이지 데이터 가져오기
    public QnAVO getQnADetail(int qa_num);
        //큐앤에이 수정
    public int uQnAModi(QnAVO vo);

    //메인화면에 큐앤에이 리스트 뽑기
    public ArrayList<QnAVO> getMainQnAList();

    //큐앤에이 삭제
    public void deleteQnA(String qa_num);


    //################## 채용공고 Service #######################
    //채용공고 목록 가져오기
    public ArrayList<EmpListVO> getJobPostList(@Param("cri") Criteria cri);
    //해당 유저가 지원한 공고 jpl_num 가져오기
    public ArrayList<EmpApplyVO> appliedList(String user_id);
    //채용공고 목록 (페이지 네이션)
    public int getJobPostTotal(@Param("cri") Criteria cri);
    //채용공고 검색 목록 가져오기
    //    public ArrayList<EmpListVO> getJobPostSrc(EmpSearchVO vo);
    public ArrayList<EmpListVO> getJobPostSrc(@Param("cri") EmpSrcCriteria cri);
    //채용공고 검색 목록 (페이지 네이션)
    public int getJobPostSrcTotal(@Param("cri") EmpSrcCriteria cri);
    //유저가 지원한 채용공고인지 찾기
    public int EmpApplied(String user_id, String jpl_num);
    //채용공고 지원하기
    public void EmpApply(String user_id, String jpl_num, String res_num);
//    기업이 입력한 채용공고 내용 유저의 채용공고 상세페이지에 뿌리기 (박희진 작성중)
//    public ArrayList<EmpVO> EmpRegistInfo();

    //메인에서 채용공고 가져오기
    public ArrayList<EmpListVO> getMainJobInfo();

    //채용공고 통계관련
    //지원자의 성별통계 구하기!!
    public ArrayList<StatisticVO> getGendertotal();

    //지원자의 이력서정보 가져오기
    public ArrayList<StatisticVO> getlookPerson(String jpl_num);


    //################## MyPage Service #######################
        //이력서 정보 가져오기
    public ArrayList<ResumeVO> resumeInfo(String user_id);
        //이력서 삭제버튼 누르면 데이터 삭제하기
    public void deleteResume(String res_num);
    public void deleteEdu(String res_num);
    public void deleteWe(String res_num);
    public void deleteCert(String res_num);


    //################## 이력서 등록  #######################
        //이력서 등록
        // 1) 이력서 -인적사항- 등록
    public void regResume(ResumeVO resVO);
        // 2) 이력서 -학력- 등록
    public void regResEdu(EduVO eduVO);
        // 3) 이력서 -경력- 등록
    public void regResWe(WeVO weVO);
        // 4) 이력서 -자격증- 등록
    public void regResCert(CertVO certVO);
        //이력서 상세페이지
        // 1) 이력서 상세 가져오기
    public ResumeVO getResDetail(String res_num);
        // 2) 이력서 학력 가져오기
    public ArrayList<EduVO> getEduDetail(String res_num);
        // 3) 이력서 경력 가져오기
    public ArrayList<WeVO> getWeDetail(String res_num);
        // 4) 이력서 자격증 가져오기
    public ArrayList<CertVO> getCertDetail(String res_num);
        // 이력서 수정
        // 1) 이력서 -인적사항- 수정
    public void modiResume(ResumeVO resVO);
        // 2) 이력서 -학력- 수정
    public void modiResEdu(EduVO eduVO);
        // 3) 이력서 -경력- 수정
    public void modiResWe(WeVO weVO);
        // 4) 이력서 -자격증- 수정
    public void modiResCert(CertVO certVO);

    //################## 지원현황(ApplyList) 관련 Service #######################
    public ArrayList<EmpApplyVO> getApplyListAll(String user_id);
    public ArrayList<EmpApplyVO> getApplyListO(String user_id);
    public ArrayList<EmpApplyVO> getApplyListX(String user_id);

    //####################### 페이지네이션 #######################

//    public Map<String, Object> uQnAListAxios(Criteria cri);

    public int uQnAGetTotal(Criteria cri);


}
