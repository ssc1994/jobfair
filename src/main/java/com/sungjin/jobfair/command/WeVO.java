package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeVO {
    private int we_num;
    private int res_num;
    private String we_company;
    private String we_department;
    private String we_position;
    private String we_job;
    private Date we_emplDate;
    private Date we_departureDate;
    private String we_salary;
}
