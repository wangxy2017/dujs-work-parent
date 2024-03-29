package com.wxy.note.controller;

import com.wxy.common.response.ApiResponse;
import com.wxy.entity.Category;
import com.wxy.service.CategoryService;
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
@Api(description = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "保存分类", notes = "保存分类")
    @PostMapping("/save")
    public ApiResponse save(@RequestParam String name) {
        int i = categoryService.saveCategory(name);
        if (i > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @ApiOperation(value = "查询分类", notes = "查询分类")
    @GetMapping("/list")
    public ApiResponse findAll() {
        List<Category> list = categoryService.findAll();
        return ApiResponse.success(list);
    }
}
