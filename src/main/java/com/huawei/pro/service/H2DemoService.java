package com.huawei.pro.service;

import com.huawei.pro.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2DemoService extends JpaRepository<User,Integer> {

}
