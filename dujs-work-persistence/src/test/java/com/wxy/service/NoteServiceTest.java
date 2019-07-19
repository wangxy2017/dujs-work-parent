package com.wxy.service;

import com.wxy.common.test.AutoValues;
import com.wxy.entity.Note;
import com.wxy.mapper.NoteMapper;
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
public class NoteServiceTest {
    @Autowired
    private NoteService noteService;

    @Test
    public void TestSaveNote() {
        String title = AutoValues.nextStr();
        String content = AutoValues.nextStr();
        int save = noteService.saveNote(title, content);
        log.info("保存笔记 save = {}", save > 0);
    }
}
