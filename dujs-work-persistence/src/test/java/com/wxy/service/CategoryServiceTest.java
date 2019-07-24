package com.wxy.service;

import com.wxy.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author wxy
 * @Date 19-7-19 下午12:03
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void TestSaveCategory() {
        String name = "默认分类";
        int i = categoryService.saveCategory(name);
        log.info("保存分类 save = {}", i);
    }

    @Test
    public void TestFindAll() {
        List<Category> list = categoryService.findAll();
        log.info("查询分类 list = {}", list);
    }
}
