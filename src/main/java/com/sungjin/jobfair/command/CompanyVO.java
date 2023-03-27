package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyVO {

    private String com_num; //기업번호
    private String com_name;
    private String com_phone;
    private String com_email;
    private String com_address;
    private String com_detail_address;
    private String com_category; //업종
    private String com_ceo;
    private String com_businessRegistration; //사업자 등록번호
    private String com_establishmentDate;
    private String com_fileName;
    private String com_filePath;
    private String com_fileUuid;

    //admin 페이지 참여업체 목록 가져오기 할 때
    //mg_auth, user_regDate 도  한번에 CompanyVO 에서 받기 위해서 변수 선언
    private String mg_auth;
    private String user_regDate;

    //업로드된 이미지 url 담기 위한 변수
    private String img_url;


}
