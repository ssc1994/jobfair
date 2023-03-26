package com.sungjin.jobfair.adminComListPagenation;

import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.command.QnAVO;
import com.sungjin.jobfair.pagination.PageVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
