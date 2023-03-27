package com.sungjin.jobfair.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class indexController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }


}
