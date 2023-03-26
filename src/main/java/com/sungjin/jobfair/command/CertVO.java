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
    private int cert_num;
    private int res_num;
    private String cert_name;
    private String cert_gainDate;
    private String cert_issueInstitute;
}
