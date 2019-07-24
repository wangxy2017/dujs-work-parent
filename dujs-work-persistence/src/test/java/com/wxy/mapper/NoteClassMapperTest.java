package com.wxy.mapper;

import com.wxy.common.test.AutoValues;
import com.wxy.entity.Note;
import com.wxy.entity.NoteClass;
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
public class NoteClassMapperTest {

    @Autowired
    private NoteClassMapper noteClassMapper;

    @Test
    public void TestSave() {
        NoteClass noteClass = new NoteClass();
        noteClass.setName(AutoValues.nextStr());
        int save = noteClassMapper.save(noteClass);
        log.info("保存笔记分类 save = {}", save > 0);
    }

    @Test
  public void TestQueryList(){
      List<NoteClass> list = noteClassMapper.queryList(null);
      log.info("查询分类列表：list = {}",list);
  }
}
