package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.PageGate;
import com.sungjin.jobfair.command.*;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.PageVO;
import com.sungjin.jobfair.service.AdminService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/jobfair")
public class AdminController {

    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    //################## 메인 #######################
    @PostMapping(value = "/getAuth")
    public ArrayList<UserVO> getAuth(Model model){
        ArrayList<UserVO> list = adminService.getAuth();
        
        return list;
    }

    //전체 가져오기
    @PostMapping(value = "/getAllData")
    public ArrayList<EmpVO> getAllData(Model model, @RequestBody CompanyVO vo){

        String com_num = vo.getCom_num();
        ArrayList<EmpVO> list = adminService.getAllData(com_num);
        System.out.println(list.toString());

        model.addAttribute("list", list);

        return list;
    }

    //전체 채용정보 페이지네이션
    @PostMapping(value = "/getEmpList")
    public ArrayList<EmpVO> getEmpList(Criteria cri) {

        ArrayList<EmpVO> list = adminService.getEmpList(cri);
        System.out.println(list.toString());

        return list;
    }

    //################## 통계 #######################

    //user의 정보를 가져와서 성비통계나타내보기
    @PostMapping(value = "/getUserInfo")
    public ArrayList<UserVO> getUserInfo(Model model){

        ArrayList<UserVO> list = adminService.getUserInfo();
        model.addAttribute("list", list);

        return list;
    }

    //통계에 인기많은 채용공고 뿌리기
    @PostMapping(value = "/getPopList")
    public ArrayList<StatisticVO> getPopList(Model model){

        ArrayList<StatisticVO> list = adminService.getPopList();
        model.addAttribute("list", list);
        System.out.println("list = " + list);

        return list;
    };


    //큐앤에이
    //큐앤에이 목록
    @PostMapping(value = "/agetQnAList")
    public ArrayList<QnAVO> agetQnAList(Criteria cri) {

        ArrayList<QnAVO> list = adminService.agetQnAList(cri);
        System.out.println(list.toString());

        return list;
    }

    //큐앤에이 페이지네이션

    @GetMapping("/aQnAListAxios")
    public PageGate list(Criteria cri) {

        int total = adminService.aQnAGetTotal(cri);
        PageVO pageVO = new PageVO(cri, total);

        ArrayList<QnAVO> list = adminService.agetQnAList(cri);

        PageGate pageGate = new PageGate(list, pageVO);

        return pageGate;
    }


    @PostMapping("/aQnAGetTotal")
    public int aQnAGetTotal(Criteria cri) {
        int total = adminService.aQnAGetTotal(cri);

        return total;
    }

}
