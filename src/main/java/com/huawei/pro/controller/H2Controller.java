package com.huawei.pro.controller;

import com.huawei.pro.bean.AppConf;
import com.huawei.pro.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class H2Controller {
    @Autowired
    private FileService fileService;

    @Autowired
    private AppConf appConf;

    @RequestMapping("/parse")
    public @ResponseBody String parse() {

        fileService.parse(appConf.getParse_dir());

        return "Start Success ! Please wait ...";
    }
}
