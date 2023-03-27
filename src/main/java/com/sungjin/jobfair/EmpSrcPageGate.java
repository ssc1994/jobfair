package com.sungjin.jobfair;

import com.sungjin.jobfair.command.EmpListVO;
import com.sungjin.jobfair.pagination.EmpSrcPageVO;
import com.sungjin.jobfair.pagination.PageVO;
import lombok.Data;

import java.util.ArrayList;

@Data
public class EmpSrcPageGate {

    private ArrayList<EmpListVO> list;
    private EmpSrcPageVO pageVO;

    public EmpSrcPageGate() {
        super();
    }

    public EmpSrcPageGate(ArrayList<EmpListVO> list, EmpSrcPageVO pageVO) {
        this.list = list;
        this.pageVO = pageVO;
    }

}
