package com.sungjin.jobfair.controller;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.command.UserVO;
import com.sungjin.jobfair.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/jobfair")
public class CompanyController {

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;

    @PostMapping("/EmpRegist")
    public String EmpRegist(@RequestBody EmpVO vo) {
        int result = companyService.empRegist(vo);

        return "" + result;
    }

    //큐앤에이 답변 등록
    @PostMapping(value = "/cqnaRegist")
    public String cqnaRegist(@RequestBody QnAVO vo) {
        companyService.cqnaRegist(vo);
        return "success";
    }

    //큐앤에이 목록 - done
    @PostMapping(value = "/cgetQnAList")
    public ArrayList<QnAVO> cgetQnAList() {

        ArrayList<QnAVO> list = companyService.cgetQnAList();
        System.out.println(list.toString());

        return list;
    }


    //QnA에서 기업정보 데이터 가져오기
    @GetMapping(value = "/cQnAInfo")
    public UserVO getComQnADetail(@RequestParam("user_id") String user_id) {

        System.out.println(user_id);
        UserVO vo = companyService.getComQnADetail(user_id);
        System.out.println("기업VO");
        System.out.println(vo.toString());

        return vo;
    }
    @GetMapping("/getQnAReply")
    public QnAVO getQnAReply(@RequestParam("qa_num") int qa_num) {
        QnAVO vo = companyService.getQnAReply(qa_num);

        return vo;
    }




}
