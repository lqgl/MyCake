package com.monoya.my.cake.commons.dtos;

import java.io.Serializable;

/**
 * 自定义返回结果
 */
public class BaseResult implements Serializable {
    //自定义状态码，200 成功， 500 错误
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    //返回的状态码
    private int status;
    //返回的信息
    private String message;
    //返回的数据
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static BaseResult success() {
        return creteResult(STATUS_SUCCESS, "成功", null);
    }

    public static BaseResult success(String message) {
        return creteResult(STATUS_SUCCESS, message, null);
    }

    public static BaseResult success(String message, Object data) {
        return creteResult(STATUS_SUCCESS, message, data);
    }

    public static BaseResult fail() {
        return creteResult(STATUS_FAIL, "失败", null);
    }

    public static BaseResult fail(String message) {
        return creteResult(STATUS_FAIL, message, null);
    }

    public static BaseResult fail(int status, String message) {
        return creteResult(status, message, null);
    }
    private static BaseResult creteResult(int status, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
}
