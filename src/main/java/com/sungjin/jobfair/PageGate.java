package com.sungjin.jobfair;

import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.pagination.PageVO;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
public class PageGate {

    private ArrayList<QnAVO> list;
    private PageVO pageVO;

    public PageGate() {
        super();
    }

    public PageGate(ArrayList<QnAVO> list, PageVO pageVO) {
        this.list = list;
        this.pageVO = pageVO;
    }

}