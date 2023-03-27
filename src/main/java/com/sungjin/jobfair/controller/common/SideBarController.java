package com.sungjin.jobfair.controller.common;

import com.sungjin.jobfair.command.MenuVO;
import com.sungjin.jobfair.service.common.sideBar.SideBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(value = "/jobfair/sidebar")
public class SideBarController {

    @Autowired
    private SideBarService sideBarService;

    @PostMapping("/getMenu")
    public ArrayList<MenuVO> getMenu(@RequestBody Map<String, String> map) {
        ArrayList<MenuVO> list = new ArrayList<>();
        String menu_id = map.get("menu_id");
        String menu_auth = map.get("menu_auth");

        list = sideBarService.getMenu(menu_id, menu_auth);
        return list;
    }
}
