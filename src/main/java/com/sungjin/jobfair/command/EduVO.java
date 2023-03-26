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
public class EduVO {
    private int edu_num;                //학력번호
    private int res_num;                //이력서번호
    private String edu_degree;          //학교구분
    private String edu_schoolName;      //학교이름
    private String edu_major;           //전공
    private Date edu_entranceDate;          //입학년도
    private Date edu_graduationDate;        //졸업년도
    private String edu_state;           //졸업상태
}
