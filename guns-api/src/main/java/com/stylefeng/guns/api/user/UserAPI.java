package com.stylefeng.guns.api.user;

/**
 * @author hncboy
 * @date 2019/9/7 8:32
 * @description TODO
 */
public interface UserAPI {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    int login(String username, String password);

    /**
     * 注册
     * @param userModel
     * @return
     */
    boolean register(UserModel userModel);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 根据 userId 查询用户信息
     * @param userId
     * @return
     */
    UserInfoModel getUserInfo(int userId);

    /**
     * 更新用户信息
     * @param userInfoModel
     * @return
     */
    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
