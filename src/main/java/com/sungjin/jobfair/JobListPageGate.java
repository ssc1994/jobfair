package com.sungjin.jobfair;

import com.sungjin.jobfair.command.EmpVO;
import com.sungjin.jobfair.pagination.JobListPageVO;
import lombok.Data;

import java.util.ArrayList;

@Data
public class JobListPageGate {
    private ArrayList<EmpVO> list;

    private JobListPageVO pageVO;

    public JobListPageGate() {super();}

    public JobListPageGate(ArrayList<EmpVO> list, JobListPageVO pageVO){
        this.list = list;
        this.pageVO = pageVO;
    }
}