package com.stylefeng.guns.api.user;

/**
 * @author hncboy
 * @date 2019/9/7 8:32
 * @description TODO
 */
public interface UserAPI {

    boolean login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);
}
