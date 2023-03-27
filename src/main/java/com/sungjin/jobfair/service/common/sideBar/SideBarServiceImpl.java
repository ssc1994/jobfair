package com.sungjin.jobfair.service.common.sideBar;

import com.sungjin.jobfair.command.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SideBarServiceImpl implements SideBarService{

    @Autowired
    SideBarMapper sideBarMapper;

    @Override
    public ArrayList<MenuVO> getMenu(String menu_id, String menu_auth) {
        return sideBarMapper.getMenu(menu_id, menu_auth);
    }
}
