package com.yl.common.api;

/**
 * @创建人 叶立
 * @创建时间 2023/5/30
 * @描述
 */
public class CommonResult<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    protected CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {

        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);

    }

    public static <T> CommonResult<T> success(String message, T data) {

        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);

    }

    public static <T> CommonResult<T> failed(String message) {

        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);

    }

    /**
     * 参数校验失败
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed() {

        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), ResultCode.VALIDATE_FAILED.getMessage(), null);

    }

    /**
     * 暂未登录或token已经过期
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized() {

        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);

    }

    /**
     * 无权限失败
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbidden() {

        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null);

    }




}
