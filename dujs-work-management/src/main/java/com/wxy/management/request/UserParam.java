package com.wxy.management.request;

import lombok.Data;

/**
 * @Author wxy
 * @Date 19-7-24 下午5:51
 * @Description TODO
 **/
@Data
public class UserParam {
    private String username;
    private String password;
    private String email;
}
