package com.huawei.pro.controller;

import com.huawei.pro.bean.AppConf;
import com.huawei.pro.bean.User;
import com.huawei.pro.service.FileService;
import com.huawei.pro.service.H2DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class H2Controller {
    @Autowired
    private FileService fileService;

    @Autowired
    private H2DemoService demoService;

    @Autowired
    private AppConf appConf;

    @RequestMapping("/parse")
    public @ResponseBody String parse() {

        fileService.parse(appConf.getParse_dir());

        return "Start Success ! Please wait ...";
    }

    @RequestMapping("/insert")
    public @ResponseBody
    String inset() {

        fileService.parse(appConf.getParse_dir());

        User user = new User("jeff", "root", 1, new Date(), "chen", 1);

        demoService.save(user);

        System.out.println(demoService.findAll().toString());
        return "wewrw";
    }
}
