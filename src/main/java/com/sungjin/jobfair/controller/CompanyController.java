package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobfair")
public class CompanyController {

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

    @PostMapping("/EmpRegist")
    public String EmpRegist(@RequestBody EmpVO vo){
        int result = companyService.empRegist(vo);

        return ""+result;
    }


}
