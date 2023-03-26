package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyVO {

    private int al_num;         //지원목록번호
    private String user_id;     //지원자 아이디
    private int jpl_num;        //채용공고 번호
    private int res_num;        //이력서 번호
    private String al_state;    //열람여부 (O : 열람, X: 미열람)
    private Date al_regDate;    //지원한 날짜


    private ResumeVO resumeVO;  // 지원한 사람의 이력서 정보
    private EmpVO empVO;

}
