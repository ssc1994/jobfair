package com.sungjin.jobfair.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.sungjin.jobfair.adminComListPagenation.AdminComListCriteria;
import com.sungjin.jobfair.adminComListPagenation.AdminComListPageVO;
import com.sungjin.jobfair.adminComListPagenation.AdminComPageGate;
import com.sungjin.jobfair.command.CompanyVO;
import com.sungjin.jobfair.service.AdminComListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("/jobfair/aComList")
public class AdminComLIstController {

    @Autowired
    @Qualifier("adminComListService")
    public AdminComListService adminComListService;

    //AWS 객체 사용하기
    @Autowired
    public AmazonS3Client amazonS3Client;

    @GetMapping("/getComList")
    public AdminComPageGate getComList( AdminComListCriteria cri){

//        System.out.println(cri.getPage());
//        System.out.println(cri.getAmount());
//        System.out.println(cri.getDateOption());
//        System.out.println(cri.getManageState());

//        int dateOption; //날짜순 정렬옵션 분기할 변수
//        int manageState = 1; //관리 상태별 정렬옵션 분기할 변수 -> 모두1,신청2,승인3,반려4

        if( cri.getManageState().equals("모두")){
            cri.setManageState("1");
        } else if (cri.getManageState().equals("신청")) {
            cri.setManageState("2");
        } else if (cri.getManageState().equals("승인")) {
            cri.setManageState("3");
        } else if (cri.getManageState().equals("반려")) {
            cri.setManageState("5");
        }

        if(cri.getDateOption().equals("최신 날짜순")){
            cri.setDateOption("1");//최신 날짜순 정렬
        } else {
            cri.setDateOption("2");//오래된 날짜순 정렬
        }

        //위에서 지정해준 조건에 따른 참여 기업 목록의 total 값 가져오기
        int total = adminComListService.getTotal(cri);

        //위에서 지정해준 조건에 따른 참여 기업 목록 (1페이지당 몇개) 가져오기
        List<CompanyVO> list = adminComListService.getComList(cri);

        //참여 기업들 리스트에서 각 기업의 로고정보를 통해 이미지 url 생성뒤 companyVO의 img_url 변수에 url 담아주기
        for(CompanyVO vo : list){
            //기업 테이블에 업로드된 이미지 파일 정보 가져와서 url 얻은뒤 각 기업의 url 변수란에 url 담아주기

            String fileUuid = vo.getCom_fileUuid();
            String fileName = vo.getCom_fileName();
            String filePath = vo.getCom_filePath();

            //업로드된 img가 있는지 없는지 따라서 분기처리
            //업로드된 이미지 파일이 없다면 no img 파일의 url 을 담아줌
            if(fileName == null){
                vo.setImg_url("https://s3.ap-northeast-2.amazonaws.com/mj-final-bucket/image/4b06db5a-2798-451b-a87a-d9892b249d72_no-img-icon2.jpg");
            } else {
            //업로드된 이미지가 있다면 이미지의 url 구해와서 담아줌
                String path = fileUuid + "_" + fileName;
                String bucket = filePath;
                String url = amazonS3Client.getUrl(bucket, path).toString();

                vo.setImg_url(url);
            }

        }

        //pageVO 생성
        AdminComListPageVO pageVO = new AdminComListPageVO(cri, total);

        //list 와 pageVO 를 담아줄 PageGate 생성, 그리고 객체들 담기
        AdminComPageGate pageGate = new AdminComPageGate(list, pageVO);

        return pageGate;
    }


}
