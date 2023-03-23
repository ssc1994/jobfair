package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpSearchVO {

    private String[] jpl_workHistory;
    private String[] jpl_workForm;
    private String[] jpl_duty;
    private String[] jpl_education;
    private String[] jpl_conditions;
    private String[] jpl_certificate;
    private String[] jpl_salary;
    private String[] jpl_locationSi;
    private String[] jpl_locationGu;
    private String inputSearch;
    private String selSortInt;


}
