package com.wxy.service;

import com.wxy.entity.NoteClass;

import java.util.List;

/**
 * @Author wxy
 * @Date 19-7-24 上午11:29
 * @Description TODO
 **/
public interface NoteClassService {
    int saveNoteClass(String name);

    List<NoteClass> findAll();
}
