package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.AdminComListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/jobfair/aComList")
public class AdminComLIstController {

    @Autowired
    @Qualifier("adminComListService")
    public AdminComListService adminComListService;

    @GetMapping("/getComList")
    public List<CompanyVO> getComList( AdminComListCriteria cri){

        System.out.println(cri.getPage());
        System.out.println(cri.getAmount());
        System.out.println(cri.getDateOption());
        System.out.println(cri.getManageState());

//        int dateOption; //날짜순 정렬옵션 분기할 변수
//        int manageState = 1; //관리 상태별 정렬옵션 분기할 변수 -> 모두1,신청2,승인3,반려4

        if( cri.getManageState().equals("모두")){
            cri.setManageState("1");
        } else if (cri.getManageState().equals("신청")) {
            cri.setManageState("2");
        } else if (cri.getManageState().equals("승인")) {
            cri.setManageState("3");
        } else if (cri.getManageState().equals("반려")) {
            cri.setManageState("5");
        }

        if(cri.getDateOption().equals("최신 날짜순")){
            cri.setDateOption("1");//최신 날짜순 정렬
        } else {
            cri.setDateOption("2");//오래된 날짜순 정렬
        }

        List<CompanyVO> list = adminComListService.getComList(cri);

//        return list;
        return null;
    }


}
