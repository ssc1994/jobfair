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
public class ResumeVO {

    private int res_num;            //이력서 번호
    private String user_id;         //아이디
    private String res_title;       //자기소개서 제목 
    private String res_content;     //자기소개서 내용
    private Date res_regDate;       //자기소개서 작성일
    private String res_picName;     //사진 이름
    private String res_picPath;     //사진 경로
    private String res_picUuid;     //사진 UUID
    private String res_name;        //이름
    private String res_email;       //이메일
    private String res_phone;       //연락처
    private String res_address;     //주소
    private Date res_birth;         //생년월일
}
