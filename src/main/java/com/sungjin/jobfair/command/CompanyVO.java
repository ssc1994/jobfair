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

    private String com_id; //기업번호
    private String com_name;
    private String com_phone;
    private String com_email;
    private String com_address;
    private String com_category; //업종
    private String com_ceo;
    private String com_businessRegistration; //사업자 등록번호
    private String com_establishmentDate;

}
