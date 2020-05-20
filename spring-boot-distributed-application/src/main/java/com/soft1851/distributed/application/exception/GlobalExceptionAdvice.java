package com.soft1851.distributed.application.exception;

import com.soft1851.distributed.application.constant.ReponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
@RestController
@Slf4j
public class GlobalExceptionAdvice {
    /**
     * 异常拦截
     *
     * @param e 异常对象
     * @return 统一处理异常后的返回值
     */
    @SuppressWarnings("all")
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ReponseResult<Object> serviceExceptionHandler(Exception e) {
        ReponseResult res = new ReponseResult();
        if (e instanceof GlobalException) {
            GlobalException se = (GlobalException) e;
            res.setCode(se.getErrorCode());
            res.setMessage(se.getMessage());
            return res;
        }
        /**
         * 参数异常处理
         */
        if (e instanceof ConstraintViolationException) {
            log.error("参数异常", e);
            ConstraintViolationException cve = (ConstraintViolationException) e;
            res.setCode(ExceptionEnum.PARAM_ERROR.getCode());
            String message = cve.getMessage();
            res.setMessage(message.substring(message.indexOf(" ") + 1, message.length()));
            return res;
        }
        log.error("服务器内部异常", e);
        //处理其他异常……
        res.setCode(ExceptionEnum.INTERNAL_ERROR.getCode());
        res.setMessage(ExceptionEnum.INTERNAL_ERROR.getMessage());
        return res;
    }
}
