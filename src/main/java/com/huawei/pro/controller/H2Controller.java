package com.huawei.pro.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class H2Controller
{

    @RequestMapping("/index")
    public String index(ModelMap map)
    {
        System.out.println("测试index");

        map.addAttribute("name","曾担任");
//        ModelAndView mv = new ModelAndView("page/index");
//
//        mv.addObject("message","Hello World");

        return "page";
    }

}
