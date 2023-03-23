package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.PageGate;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.pagination.Criteria;
import com.sungjin.jobfair.pagination.PageVO;
import com.sungjin.jobfair.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
