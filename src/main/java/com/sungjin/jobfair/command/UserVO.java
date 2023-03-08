package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
    private String user_id;
    private String user_pw;
    private String mg_auth; //권한 1: 구직자, 2: 기업(승인 전), 3: 기업(승인 완료), 4: admin
    private String user_name;
    private String user_rrn; //주민등록번호
    private String user_email;
    private String user_phone;
    private String user_regDate; //가입일
    private String user_gender;
    private String user_address;
    private String com_id; //기업id

    public void setUser_regDate(String user_regDate) {
        this.user_regDate = user_regDate;
    }
}