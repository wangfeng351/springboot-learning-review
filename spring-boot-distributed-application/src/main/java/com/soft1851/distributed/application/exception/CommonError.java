package com.soft1851.distributed.application.exception;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
public interface CommonError {

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getErrorMessage();

    /**
     * 获取错误编码
     *
     * @return 错误码
     */
    Integer getErrorCode();

    /**
     * 设置错误信息
     *
     * @param errorMessage 错误信息
     * @return 错误信息对象
     */
    CommonError setErrorMessage(String errorMessage);
}
