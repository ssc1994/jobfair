package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String user_rrn; //가입자 연령대 구해보기..
    private String jpl_num; //각각의 채용공고 번호 가져오기

}

