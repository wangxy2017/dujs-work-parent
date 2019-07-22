package com.wxy.mapper;

import com.wxy.common.test.AutoValues;
import com.wxy.entity.Bookmark;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookmarkMapperTest {

    @Autowired
    private BookmarkMapper bookmarkMapper;

    @Test
    public void TestSave() {
        Bookmark bookmark = new Bookmark();
        bookmark.setIcon(AutoValues.nextStr());
        bookmark.setHref(AutoValues.nextStr());
        bookmark.setName(AutoValues.nextStr());
        int save = bookmarkMapper.save(bookmark);
        log.info("保存书签 save = {}", save > 0);
    }

    @Test
    public void TestSaveByBatch() {
        List<Bookmark> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Bookmark bookmark = new Bookmark();
            bookmark.setIcon(AutoValues.nextStr());
            bookmark.setHref(AutoValues.nextStr());
            bookmark.setName(AutoValues.nextStr());
            list.add(bookmark);
        }
        int save = bookmarkMapper.saveByBatch(list);
        log.info("批量保存书签 save = {}", save);
    }

    @Test
    public void TestQueryList(){
        List<Bookmark> list = bookmarkMapper.queryList(null);
        log.info("查询书签列表：list = {}",list.size());
    }
}
