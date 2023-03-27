package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpListVO {

    private String com_name;
    private String user_id;
    private String jpl_num;
    private String com_num;
    private String jpl_title;
    private String jpl_content;
    private String jpl_startDate;
    private String jpl_endDate;
    private String jpl_regDate;
    private String jpl_workPosition;
    private String jpl_duty;
    private String jpl_workHistory;
    private String jpl_workForm;
    private String jpl_education;
    private String jpl_conditions;
    private String jpl_certificate;
    private String jpl_gender;
    private String jpl_salary;
    private String jpl_locationSi;
    private String jpl_locationGu;
    private String jpl_address;
    private String jpl_workDay;
    private String jpl_workTimeS;
    private String jpl_workTimeE;
    private String jpl_name;
    private String jpl_companyName;
    private String jpl_contact;
    private String jpl_phoneNum;
    private String jpl_email;
    private String jpl_fileName;
    private String jpl_filePath;
    private String jpl_fileUuid;

    private String url;
}
