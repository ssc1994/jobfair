package com.sungjin.jobfair.pagination.adminComList;
import lombok.Data;

@Data
public class AdminComListCriteria {

    //SQL에 전달할 page, amount 을 가지고 다니는 클래스
    private int page; //조회하는 페이지 번호
    private int amount; //데이터개수

    //정렬키워드
    String dateOption; //날짜순 정렬옵션 분기할 변수
    String manageState; //관리 상태별 정렬옵션 분기할 변수 -> 모두1,신청2,승인3,반려4


    public AdminComListCriteria() {
        this.page = 1;
        this.amount = 10;
    }

    public AdminComListCriteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    public int getPageStart() {
        return (page - 1) * amount;
    }

}
