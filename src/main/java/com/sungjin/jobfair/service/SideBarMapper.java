package com.sungjin.jobfair.service;

import com.sungjin.jobfair.command.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface SideBarMapper {
    //메뉴 아코디언에 들어갈 서브메뉴 목록 받아오기
    ArrayList<MenuVO> getMenu(@Param("menu_id") String menu_id, @Param("menu_auth") String menu_auth);
}
