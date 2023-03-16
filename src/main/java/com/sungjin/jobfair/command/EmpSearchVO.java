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

    private ArrayList<String> jpl_workHistory;
    private ArrayList<String> jpl_workForm;
    private ArrayList<String> jpl_duty;
    private ArrayList<String> jpl_education;
    private ArrayList<String> jpl_conditions;
    private ArrayList<String> jpl_certificate;
    private ArrayList<String> jpl_salary;
    private ArrayList<String> jpl_locationSi;
    private ArrayList<String> jpl_locationGu;
    private String inputSearch;


}
