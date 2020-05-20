package com.soft1851.distributed.application.controller;

import com.soft1851.distributed.application.constant.ReponseResult;
import com.soft1851.distributed.application.exception.ExceptionEnum;
import com.soft1851.distributed.application.exception.GlobalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags = "测试接口")
public class TestController {

    @GetMapping("/getData")
    @ApiOperation("getData 请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", dataTypeClass = String.class)
            //@ApiImplicitParam(name = "aaa", value = "名称", dataTypeClass = String.class,required = true)
    })
    public String getData(String name) {
        log.info("getData 请求，请求参数=[{}]", name);
        return "test" + name;
    }
}
