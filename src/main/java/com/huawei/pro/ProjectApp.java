package com.huawei.pro;

import com.huawei.pro.bean.AppConf;
import com.huawei.pro.utils.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.*;

@SpringBootConfiguration
@SpringBootApplication
public class ProjectApp {

    private static AppConf myconf;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProjectApp.class, args);

        LogUtil.log.info("Config parse : do with application.properties");
//        Debug.println("Config parse","do with application.properties");

        myconf = (AppConf) ctx.getBean("appConf");
//初始化H2数据库
        initH2();

        LogUtil.log.info("Start Success on port :" + myconf.getPort());

    }

    private static void initH2() {
        try {
            //获取连接
            Connection conn = DriverManager.getConnection(myconf.getUrl(), "root", "root");
            Statement stat = conn.createStatement();

            //创建数据库hello
            stat.executeUpdate("create schema if not exists test;");
//        stat.executeUpdate("create database hello");

            //创建表test
            stat.executeUpdate("create table test.test(id int, name varchar(80))");

            stat.close();
            conn.close();

            conn = DriverManager.getConnection(myconf.getUrl(), "root", "root");
            stat = conn.createStatement();

            //添加数据
            stat.executeUpdate("insert into test.test values(1, '张三')");
            stat.executeUpdate("insert into test.test values(2, '李四')");

            //查询数据
            ResultSet result = stat.executeQuery("select * from test.test");
            while (result.next()) {
                System.out.println(result.getInt("id") + " " + result.getString("name"));
            }

            //打开创建的数据库
            result.close();
            stat.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
