package com.stylefeng.guns.api.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hncboy
 * @date 2019/9/7 10:36
 * @description 用户注册实体类
 */
@Getter
@Setter
public class UserModel {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
}
