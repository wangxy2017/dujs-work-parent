package com.wxy.service;

import com.wxy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wxy
 * @Date 19-7-19 下午12:03
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void TestSaveUser() {
        String username = "admin";
        String password = "admin";
        String email = "admin@qq.com";
        int i = userService.saveUser(username, password, email);
        log.info("保存用户：user = {}",i>0);
    }

    @Test
    public void TestQueryById(){
        Long id = 2L;
        User user = userService.queryById(id);
        log.info("根据ID查询 user = {}", user);
    }
}
