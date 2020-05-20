package com.soft1851.distributed.application.exception;

import java.util.concurrent.RecursiveTask;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
public class GlobalException extends RuntimeException implements CommonError {

    private ExceptionEnum exceptionEnum;
    /**
     * 异常编号
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    public Integer getCode() {
        return this.exceptionEnum.getCode();
    }

    public GlobalException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public GlobalException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return getErrorMessage();
    }

    @Override
    public String getErrorMessage() {
        return exceptionEnum.getErrorMessage();
    }

    @Override
    public Integer getErrorCode() {
        return exceptionEnum.getErrorCode();
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        exceptionEnum.setErrorMessage(errorMessage);
        return this;
    }
}
