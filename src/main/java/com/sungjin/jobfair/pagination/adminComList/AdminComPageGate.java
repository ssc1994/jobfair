package com.sungjin.jobfair.pagination.adminComList;

import com.sungjin.jobfair.command.CompanyVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminComPageGate {

    private List<CompanyVO> list;
    private AdminComListPageVO pageVO;


    public AdminComPageGate(List<CompanyVO> list, AdminComListPageVO pageVO) {
        this.list = list;
        this.pageVO = pageVO;
    }
}
