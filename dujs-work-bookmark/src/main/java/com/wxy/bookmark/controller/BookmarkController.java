package com.wxy.bookmark.controller;

import com.wxy.common.response.ApiResponse;
import com.wxy.entity.Bookmark;
import com.wxy.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author wxy
 * @Date 19-7-22 上午10:38
 * @Description TODO
 **/
@RestController
@RequestMapping("/bookmark")
@Slf4j
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PutMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        log.info("上传文件：file = {}", file.getOriginalFilename());
    }

    @GetMapping("/list")
    public ApiResponse list() {
        List<Bookmark> list = bookmarkService.queryList(null);
        return ApiResponse.success(list);
    }
}
