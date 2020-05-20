package com.soft1851.distributed.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum implements CommonError {

    /**
     * 常见异常枚举
     */
    PARAM_ERROR(-1, "参数异常"),
    INTERNAL_ERROR(500, "服务器内部错误"),
    DATA_ERROR(600, "数据异常"),
    DATA_NOT_EXIST(601, "数据不存在"),
    DATA_ALREADY_EXIST(602, "数据已经存在"),
    UN_AUTHENTICATION(40003, "请求未认证"),
    UN_AUTHORIZATION(40005, "请求未授权"),

    ;
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    @Override
    public String getErrorMessage() {
        return this.message;
    }

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.message = errorMessage;
        return this;
    }
}
