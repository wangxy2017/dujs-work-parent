package com.wxy.mapper;

import com.wxy.common.test.AutoValues;
import com.wxy.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void TestSave() {
        Category category = new Category();
        category.setName(AutoValues.nextStr());
        int save = categoryMapper.save(category);
        log.info("保存分类 save = {}", save > 0);
    }

    @Test
    public void TestQueryList() {
        List<Category> list = categoryMapper.queryList(null);
        log.info("查询分类列表：list = {}", list);
    }
}
