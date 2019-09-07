package com.stylefeng.guns.rest.modular.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.Accessors;

/**
 * @author hncboy
 * @date 2019/9/7 13:36
 * @description 统一返回的结果
 */
@Accessors(chain = true)
@Getter
@Setter
public class ResponseVO<T> {

    /**
     * 200 成功 500 服务异常 404 系统异常
     */
    private Integer status;

    private String message;

    private T data;

    private ResponseVO() {
    }

    /**
     * 请求成功
     *
     * @param object
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseVO success(T object) {
        return new ResponseVO().setStatus(200).setData(object).setMessage("请求成功");
    }

    public static <T> ResponseVO success(String message) {
        return new ResponseVO().setStatus(200).setMessage(message).setMessage("请求成功");
    }

    /**
     * 服务异常
     *
     * @param message
     * @return
     */
    public static ResponseVO serviceFail(String message) {
        return new ResponseVO().setStatus(500).setMessage(message);
    }

    /**
     * 系统异常
     *
     * @param message
     * @return
     */
    public static ResponseVO systemFail(String message) {
        return new ResponseVO().setStatus(404).setMessage(message);
    }
}
