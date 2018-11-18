package com.huawei.pro;

import com.huawei.pro.bean.AppConf;
import com.huawei.pro.utils.LogUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sun.security.ssl.Debug;

@SpringBootConfiguration
@SpringBootApplication
public class ProjectApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProjectApp.class, args);

        LogUtil.log.info("Config parse : do with application.properties");
//        Debug.println("Config parse","do with application.properties");

        AppConf myconf = (AppConf) ctx.getBean("appConf");

        LogUtil.log.info("Start Success on port :" + myconf.getPort());

    }


}
