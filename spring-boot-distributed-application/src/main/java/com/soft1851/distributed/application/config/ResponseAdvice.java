package com.soft1851.distributed.application.config;

import com.soft1851.distributed.application.constant.ReponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description 统一rest接口处理
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
@RestControllerAdvice(annotations = {RestController.class})
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //统一返回拦截
        if (null == o) {
            return ReponseResult.success();
        } else if (o instanceof ReponseResult) {
            return o;
        } else {
            ReponseResult<Object> res = ReponseResult.success();
            res.setData(o);
            return res;
        }
    }
}
