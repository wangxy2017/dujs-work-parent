package com.wxy.mapper;

import com.wxy.common.test.AutoValues;
import com.wxy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestSave() {
        User user = new User();
        user.setUsername(AutoValues.nextStr());
        user.setPassword(AutoValues.nextStr());
        user.setEmail(AutoValues.nextStr());
        user.setSalt(AutoValues.nextStr());
        int save = userMapper.save(user);
        log.info("保存用户 save = {}", save > 0);
    }

    @Test
    public void TestQueryById() {
        Long id = 1L;
        User user = userMapper.queryById(id);
        log.info("根据ID查询 User = {}", user);
    }
}
