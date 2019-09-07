package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.api.user.UserInfoModel;

/**
 * @author hncboy
 * @date 2019/9/7 13:52
 * @description 用户当前对象
 */
public class CurrentUser {

    /**
     * 线程绑定的存储空间
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 将用户信息存入存储空间
     *
     * @param userId
     */
    public static void saveUserId(String userId) {
        THREAD_LOCAL.set(userId);
    }

    /**
     * 获取当前用户信息
     *
     * @return
     */
    public static String getCurrentUser() {
        return THREAD_LOCAL.get();
    }
}
