package com.wxy.note.controller;

import com.wxy.common.response.ApiResponse;
import com.wxy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author wxy
 * @Date 19-7-19 下午12:15
 * @Description TODO
 **/
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public ApiResponse save(Map<String, String> params) {
        String title = params.get("title");
        String content = params.get("content");
        int save = noteService.saveNote(title, content);
        if (save > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }
}
