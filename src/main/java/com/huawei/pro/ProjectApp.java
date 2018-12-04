package com.huawei.pro;

import com.huawei.pro.bean.AppConf;
import com.huawei.pro.utils.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootConfiguration
@SpringBootApplication
public class ProjectApp {

    private static AppConf myconf;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProjectApp.class, args);

        LogUtil.log.info("Config parse : do with application.properties");
//        Debug.println("Config parse","do with application.properties");

        myconf = (AppConf) ctx.getBean("appConf");
//      初始化H2数据库,创建PROJECT数据库
        initH2();

        LogUtil.log.info("Start Success on port :" + myconf.getPort());

    }

    private static void initH2() {
        try {
            //获取连接
            Connection conn = DriverManager.getConnection(myconf.getUrl(), "root", "root");
            Statement stat = conn.createStatement();

            //创建数据库PROJECT
            stat.executeUpdate("create schema if not exists PROJECT;");

            stat.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
