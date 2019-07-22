package com.wxy.bookmark.controller;

import com.wxy.common.response.ApiResponse;
import com.wxy.common.tool.IDUtils;
import com.wxy.entity.Bookmark;
import com.wxy.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
    public ApiResponse upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("上传文件：file = {}", file.getOriginalFilename());
        if (file.getOriginalFilename().endsWith(".html")) {
            File tempFile = new File("tmp-" + IDUtils.getUUID() + ".html");
            file.transferTo(tempFile);
            List<Bookmark> bookmarks = new ArrayList<>();
            Document document = Jsoup.parse(tempFile,"UTF-8");
            Elements elements = document.getElementsByTag("A");
            elements.forEach(a -> {
                Bookmark b = new Bookmark();
                b.setIcon("123");
                b.setHref(a.attr("HREF"));
                b.setName(a.html());
                bookmarks.add(b);
            });
            tempFile.delete();
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @GetMapping("/list")
    public ApiResponse list() {
        List<Bookmark> list = bookmarkService.queryList(null);
        return ApiResponse.success(list);
    }
}
