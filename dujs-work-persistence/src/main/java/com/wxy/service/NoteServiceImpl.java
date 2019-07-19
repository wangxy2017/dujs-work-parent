package com.wxy.service;

import com.wxy.common.encryption.AESUtils;
import com.wxy.common.tool.CodeUtils;
import com.wxy.entity.Note;
import com.wxy.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Author wxy
 * @Date 19-7-19 上午11:57
 * @Description TODO
 **/
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public int saveNote(String title, String content) {
        Assert.hasText(title, "The parameter title is required");
        Assert.hasText(content, "The parameter content is required");
        Note note = new Note();
        note.setTitle(title);
        note.setPassword(CodeUtils.random(8));
        note.setContent(AESUtils.encrypt(content, note.getPassword()));
        return noteMapper.save(note);
    }

    @Override
    public Note queryById(Long id) {
        Assert.notNull(id, "The parameter id is required");
        Note note = noteMapper.queryById(id);
        if (note != null) {
            note.setContent(AESUtils.decrypt(note.getContent(), note.getPassword()));
            return note;
        }
        return null;
    }
}
