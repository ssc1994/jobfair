package com.sungjin.jobfair.pagination.empSrc;

import com.sungjin.jobfair.command.EmpSearchVO;
import lombok.Data;

import java.util.List;

@Data
public class EmpSrcCriteria {

    //페이징
    private int page; //페이지번호 - 프론트에서 보내줘야함
    private int amount; //데이터개수


    //정렬키워드 (채용공고)
    private String selSortInt; //채용공고 정렬옵션 분기할 변수

    //검색 키워드 (채용공고)
    private String [] jpl_locationSi;
    private String [] jpl_locationGu;
    private String[] jpl_duty;
    private String inputSearch;
    private String[] jpl_workHistory;
    private String[] jpl_education;
    private String[] jpl_salary;
    private String[] jpl_certificate;
    private String[] jpl_conditions;
    private String[] jpl_workForm;

    public EmpSrcCriteria() { //초기값 지정 -> 롬복 사용시 초기값 지정이 불가능해서 직접 지정해줌
        this.page = 1;
        this.amount = 10;
    }

    public EmpSrcCriteria(int page, int amount) {
        super();
        this.page = page;
        this.amount = amount;
    }

    // 페이지시작 부분에 들어갈 getter
    public int getPageStart() {
        return (page -1 ) * amount;
    }

}
