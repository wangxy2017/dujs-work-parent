package com.wxy.service.impl;

import com.wxy.entity.NoteClass;
import com.wxy.mapper.NoteClassMapper;
import com.wxy.service.NoteClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Author wxy
 * @Date 19-7-24 上午11:31
 * @Description TODO
 **/
@Service
public class NoteClassServiceImpl implements NoteClassService {

    @Autowired
    private NoteClassMapper noteClassMapper;

    @Override
    public int saveNoteClass(String name) {
        Assert.hasText(name, "The parameter name is required");
        NoteClass noteClass = new NoteClass();
        noteClass.setName(name);
        return noteClassMapper.save(noteClass);
    }

    @Override
    public List<NoteClass> findAll() {
        return noteClassMapper.queryList(null);
    }
}
