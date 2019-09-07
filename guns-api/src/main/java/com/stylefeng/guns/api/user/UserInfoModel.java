package com.stylefeng.guns.api.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hncboy
 * @date 2019/9/7 13:20
 * @description 用户具体信息实体类
 */
@Getter
@Setter
public class UserInfoModel {

    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private Long createTime;
    private Long updateTime;
}
