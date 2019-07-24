package com.wxy.management.controller;

import com.wxy.common.response.ApiResponse;
import com.wxy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author wxy
 * @Date 19-7-24 下午5:42
 * @Description TODO
 **/
@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "保存用户", notes = "保存用户")
    @PostMapping("/save")
    public ApiResponse save(@RequestBody Map<String, Object> params) {
        String username = String.valueOf(params.get("username"));
        String password = String.valueOf(params.get("password"));
        String email = String.valueOf(params.get("email"));
        if (userService.saveUser(username, password, email) > 0) {
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }
}
