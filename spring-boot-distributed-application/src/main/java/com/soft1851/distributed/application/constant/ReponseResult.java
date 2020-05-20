package com.soft1851.distributed.application.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description 统一返回值封装
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReponseResult<T> implements Serializable {
    private static final Integer SUCCESS_CODE = 200;
    private static final String SUCCESS_MESSAGE = "success";

    /**
     * 响应编码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 请求时间
     */
    private LocalDateTime qt;
    /**
     * 响应时间
     */
    private LocalDateTime rt;
    /**
     * 语言
     */
    private Integer lang;
    /**
     * 响应数据
     */
    private T data;

    public static ReponseResult<Object> success() {
        ReponseResult<Object> res = new ReponseResult<>();
        res.setCode(SUCCESS_CODE);
        res.setMessage(SUCCESS_MESSAGE);
        return res;
    }
}
