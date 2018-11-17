package com.huawei.pro;

import com.huawei.pro.bean.AppConf;
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

        Debug.println("Config parse","do with application.properties");

        AppConf myconf = (AppConf) ctx.getBean("appConf");

    }


}
