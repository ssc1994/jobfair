package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyControllerTest {

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

    @Test
    void empRegistTest() {

        for(int i = 1; i <= 20; i ++) {
            LocalDate now = LocalDate.now();
            String endDate = (now.plusDays(i)).toString();

            EmpVO vo = new EmpVO();
            vo.setJpl_num("");
            vo.setCom_num(i % 2 == 0 ? "1" : "2");
            vo.setJpl_title("채용공고" + i);
            vo.setJpl_content("채용공고 관련 내용입니다." + i);
            vo.setJpl_startDate("2023-03-17");
            vo.setJpl_endDate(endDate);
            vo.setJpl_regDate(now.toString());
            vo.setJpl_workPosition("포지션" + i);
            vo.setJpl_duty("듀티");
            vo.setJpl_workHistory(i % 2 == 0 ? "신입" : "경력");
            vo.setJpl_workForm(i % 2 == 0 ? "정규직" : "계약직");
            vo.setJpl_education((i % 2 == 0 ? "대졸(4년제)" : "고졸"));
            vo.setJpl_conditions("없음");
            vo.setJpl_certificate("토익");
            vo.setJpl_gender(i % 2 == 0 ? "남" : "여");
            vo.setJpl_salary(String.valueOf(2000 + (i * 100)));
            vo.setJpl_locationSi(i % 2 == 0 ? "Seoul" :  "경기도");
            vo.setJpl_locationGu(i % 2 == 0 ? "강남" : "성남시");
            vo.setJpl_address("본사");
            vo.setJpl_workDay(i % 2 == 0 ? "주 5일(월~금)" : "주 3일");
            vo.setJpl_workTimeS("09:00");
            vo.setJpl_workTimeE("18:00");
            vo.setJpl_name("홍길동");
            vo.setJpl_companyName("홍길동소프트");
            vo.setJpl_contact("02-111-1111");
            vo.setJpl_phoneNum("010-1111-1111");
            vo.setJpl_email("hong@jil.dong");
            vo.setJpl_fileName("1.jpg");
            vo.setJpl_fileUuid("df989f81-7934-493f-a1e5-ca98a8c650a1");
            vo.setJpl_filePath("C:/bootupload");
            System.out.println("vo = " + vo);
            companyService.empRegist(vo);
        }
        System.out.println("성공");
    }
}