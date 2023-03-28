package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticVO {

    //    admin 의 통계페이지에서 쓰는 거
    private int cnt; //카운트숫자
    private String jpl_title; //해당공고제목

    //    company의 공고 상세보기에 있는 통계
    private String user_gender; //가입자 성별

    private String user_name; //가입자이름
    private ResumeVO resumeVO;  // 지원한 사람의 이력서 정보
    private String jpl_num; //각각의 채용공고 번호 가져오기

    private int res_num;            //이력서 번호
    private String res_title;       //자기소개서 제목
    private Date res_regDate;       //자기소개서 작성일

}

