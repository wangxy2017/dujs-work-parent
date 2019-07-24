package com.wxy.note.controller;

import com.wxy.common.response.ApiResponse;
import com.wxy.entity.NoteClass;
import com.wxy.service.NoteClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wxy
 * @Date 19-7-24 下午1:35
 * @Description TODO
 **/
@Api(description = "笔记分类管理")
@RestController
@RequestMapping("/noteClass")
public class NoteClassController {

    @Autowired
    private NoteClassService noteClassService;

    @ApiOperation(value = "保存分类", notes = "保存分类")
    @PostMapping("/save")
    public ApiResponse save(@RequestParam String name) {
        int i = noteClassService.saveNoteClass(name);
        if (i > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @ApiOperation(value = "查询分类", notes = "查询分类")
    @GetMapping("/list")
    public ApiResponse findAll() {
        List<NoteClass> list = noteClassService.findAll();
        return ApiResponse.success(list);
    }
}
