package com.sungjin.jobfair.pagination;

import com.sungjin.jobfair.command.EmpListVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.pagination.PageVO;
import lombok.Data;

import java.util.ArrayList;

@Data
public class EmpPageGate {

    private ArrayList<EmpListVO> list;
    private PageVO pageVO;

    public EmpPageGate() {
        super();
    }

    public EmpPageGate(ArrayList<EmpListVO> list, PageVO pageVO) {
        this.list = list;
        this.pageVO = pageVO;
    }

}
