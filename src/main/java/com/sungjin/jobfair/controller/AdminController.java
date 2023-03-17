package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/jobfair")
public class AdminController {

    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    //**********************************************채용공고**********************************************

    //채용공고 작성정보
    @PostMapping("/getEmpData")
    public ArrayList<EmpVO> getEmpData(){

        ArrayList<EmpVO> list = adminService.getEmpData();
//        System.out.println("list = " + list);
        return list;
    }

    //기업정보
    @PostMapping("/getComData")
    public ArrayList<CompanyVO> getComData(@RequestBody CompanyVO vo){

        String com_num = vo.getCom_num();
        ArrayList<CompanyVO> list = adminService.getComData(com_num);
//        System.out.println("vo = " + vo);
//        System.out.println("com_num = " + com_num);
//        System.out.println("list = " + list);
        return list;
    }
}
