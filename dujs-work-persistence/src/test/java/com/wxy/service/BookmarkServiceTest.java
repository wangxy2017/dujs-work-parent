package com.wxy.service;

import com.wxy.entity.Bookmark;
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
public class BookmarkServiceTest {
    @Autowired
    private BookmarkService bookmarkService;

    @Test
    public void TestSaveBookmarkByBatch() {

    }

    @Test
    public void TestQueryList() {
        List<Bookmark> list = bookmarkService.queryList(null);
        log.info("查询书签：list = {}", list.size());
    }
}
