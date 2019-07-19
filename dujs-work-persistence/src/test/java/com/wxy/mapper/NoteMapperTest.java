package com.wxy.mapper;

import com.wxy.common.test.AutoValues;
import com.wxy.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class NoteMapperTest {

    @Autowired
    private NoteMapper noteMapper;

    @Test
    public void TestSave() {
        Note note = new Note();
        note.setTitle(AutoValues.nextStr());
        note.setContent(AutoValues.nextStr());
        note.setPassword(AutoValues.nextStr());
        int save = noteMapper.save(note);
        log.info("保存笔记 save = {}", save > 0);
    }

    @Test
    public void TestQueryById() {
        Long id = 1L;
        Note note = noteMapper.queryById(id);
        log.info("根据ID查询 note = {}", note);
    }
}
