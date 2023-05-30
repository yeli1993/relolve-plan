package com.yl.common.api;

/**
 * @创建人 叶立
 * @创建时间 2023/5/30
 * @描述
 */
public interface IErrorCode {

    /**
     * 返回状态码
     * @return
     */
    public String getCode();

    /**
     * 返回消息
     * @return
     */
    public String getMessage();

}
