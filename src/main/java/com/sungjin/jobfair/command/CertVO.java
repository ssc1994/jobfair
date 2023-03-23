package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertVO {
    private int cert_num;                   //자격증번호
    private int res_num;                    //이력서번호
    private String cert_name;               //자격증명
    private String cert_gainDate;           //취득일
    private String cert_issueInstitute;     //발행처
}
