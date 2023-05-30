package com.yl.common.api;

import lombok.Data;

/**
 * @创建人 叶立
 * @创建时间 2023/5/30
 * @描述
 */
public enum ResultCode implements IErrorCode {
    SUCCESS("200", "操作成功"),
    FAILED("999", "操作失败"),
    VALIDATE_FAILED("404", "参数检验失败"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限");

    private String code;
    private String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回状态码
     *
     * @return
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * 返回消息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}
