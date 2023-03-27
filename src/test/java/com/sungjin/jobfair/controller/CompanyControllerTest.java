//package com.sungjin.jobfair.controller;
//
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.sungjin.jobfair.command.*;
//import com.sungjin.jobfair.service.CompanyService;
//import com.sungjin.jobfair.service.UserService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class CompanyControllerTest {
//
//    @Autowired
//    @Qualifier("companyService")
//    private CompanyService companyService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    AmazonS3Client amazonS3Client;
//
//    @Value("${cloud.aws.s3.bucket}")
//    String bucket;
//
//    @Test
//    public void test02() {
//        String path = "6c0bab13-c78f-4e66-bf30-52a2a074f8dc_KakaoTalk_20221111_09392105422.png";
//
//        String url = amazonS3Client.getUrl(bucket, path).toString();
//        Assertions.assertThat(url).isNotNull();
//        System.out.println(url);
//    }
//
//
//    @Test
//    void resRegistTest() {
//
//        int rrr = 1;
//        int eee = 1;
//        int www = 1;
//
//        for (int i = 1; i <= 5; i++) {
//            LocalDate now = LocalDate.now();
//            now.plusDays(i - 1);
//            Date date = Date.valueOf(now);
//            ResumeVO rvo = new ResumeVO();
//            EduVO evo = new EduVO();
//            WeVO wvo = new WeVO();
//            CertVO cvo = new CertVO();
//
//            rvo.setRes_num(i);
//            rvo.setUser_id("aaa123");
//            rvo.setRes_title(i + "번 이력서의 제목입니다.");
//            rvo.setRes_content(i + "번 이력서의 내용입니다.");
//            rvo.setRes_regDate(date);
//            rvo.setRes_picName("1.jpg");
//            rvo.setRes_picPath("C:/bootupload");
//            rvo.setRes_picUuid("df989f81-7934-493f-a1e5-ca98a8c650a1");
//            rvo.setRes_name("테스트" + i);
//            rvo.setRes_email("test@naver.com");
//            rvo.setRes_phone("010-1111-1111");
//            rvo.setRes_address("서울");
//            rvo.setRes_birth(new Date(1992, 2, 11));
//
//            evo.setEdu_num(i);
//            evo.setRes_num(i);
//            evo.setEdu_degree("university");
//            evo.setEdu_schoolName("경기대");
//            evo.setEdu_major("호텔경영");
//            evo.setEdu_entranceDate(new Date(2012, 3, 01));
//            evo.setEdu_graduationDate(new Date(2017, 07, 18));
//            evo.setEdu_state("1");
//            evo.setEdu_grades("4.0");
//            evo.setEdu_state("4.5");
//
//            wvo.setWe_num(i);
//            wvo.setRes_num(i);
//            wvo.setWe_company("노보텔");
//            wvo.setWe_department("객실부");
//            wvo.setWe_position("사원");
//            wvo.setWe_job("프론트");
//            wvo.setWe_emplDate(new Date(2017, 9, 16));
//            wvo.setWe_departureDate(new Date(2021, 3, 25));
//            wvo.setWe_salary("2000");
//
//            cvo.setCert_num(i);
//            cvo.setRes_num(i);
//            cvo.setCert_name("토익");
//            cvo.setCert_gainDate("2020-11-20");
//            cvo.setCert_issueInstitute("토익");
//
//            userService.regResume(rvo);
//            userService.regResEdu(evo);
//            userService.regResWe(wvo);
//            userService.regResCert(cvo);
//        }
//    }
//
//    @Test
//    void empRegistTest() {
//
//        for (int i = 1; i <= 20; i++) {
//            LocalDate now = LocalDate.now();
//            String endDate = (now.plusDays(i)).toString();
//
//            EmpVO vo = new EmpVO();
//            vo.setJpl_num("");
//            vo.setCom_num(i % 2 == 0 ? "1" : "2");
//            vo.setJpl_title("채용공고" + i);
//            vo.setJpl_content("채용공고 관련 내용입니다." + i);
//            vo.setJpl_startDate("2023-03-17");
//            vo.setJpl_endDate(endDate);
//            vo.setJpl_regDate(now.toString());
//            vo.setJpl_workPosition("포지션" + i);
//            vo.setJpl_duty("듀티");
//            vo.setJpl_workHistory(i % 2 == 0 ? "신입" : "경력");
//            vo.setJpl_workForm(i % 2 == 0 ? "정규직" : "계약직");
//            vo.setJpl_education((i % 2 == 0 ? "대졸(4년제)" : "고졸"));
//            vo.setJpl_conditions("없음");
//            vo.setJpl_certificate("토익");
//            vo.setJpl_gender(i % 2 == 0 ? "남" : "여");
//            vo.setJpl_salary(String.valueOf(2000 + (i * 100)));
//            vo.setJpl_locationSi(i % 2 == 0 ? "Seoul" : "경기도");
//            vo.setJpl_locationGu(i % 2 == 0 ? "강남" : "성남시");
//            vo.setJpl_address("본사");
//            vo.setJpl_workDay(i % 2 == 0 ? "주 5일(월~금)" : "주 3일");
//            vo.setJpl_workTimeS("09:00");
//            vo.setJpl_workTimeE("18:00");
//            vo.setJpl_name("홍길동");
//            vo.setJpl_companyName("홍길동소프트");
//            vo.setJpl_contact("02-111-1111");
//            vo.setJpl_phoneNum("010-1111-1111");
//            vo.setJpl_email("hong@jil.dong");
//            vo.setJpl_fileName("1.jpg");
//            vo.setJpl_fileUuid("df989f81-7934-493f-a1e5-ca98a8c650a1");
//            vo.setJpl_filePath("C:/bootupload");
//            System.out.println("vo = " + vo);
//            companyService.empRegist(vo);
//        }
//        System.out.println("성공");
//    }
//}