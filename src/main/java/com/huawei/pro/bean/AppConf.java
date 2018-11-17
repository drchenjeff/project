package com.huawei.pro.bean;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppConf {

    @Autowired
    private Environment env;

    private static String parse_dir;

    public String getParse_dir() {
        return env.getProperty("file.dir");
    }

    public void setParse_dir(String parse_dir) {
        this.parse_dir = parse_dir;
    }

//    public void show(){
//        System.out.println("===========================================");
//        //获取字符串
//        System.out.println("String: " +env.getProperty("string.port") + 1111);
//
//        //获取整数
//        System.out.println("Interger:   " + (env.getProperty("integer.port",Integer.class) + 1111 ));
//        System.out.println(env.getProperty("db.link.url"));
//        System.out.println(env.getProperty("db.link.driver"));
//        System.out.println(env.getProperty("db.link.username"));
//        System.out.println(env.getProperty("db.link.password"));
//        System.out.println("===========================================");
//    }

}
