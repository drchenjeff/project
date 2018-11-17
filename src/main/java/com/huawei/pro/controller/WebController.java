package com.huawei.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "陈大荣");

        return "index";
    }
}
