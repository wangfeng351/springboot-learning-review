package com.soft1851.springboot.configuration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Description HTTPS测试
 * @Author wf
 * @Date 2020/5/12
 * @Version 1.0
 */
@RestController
@Slf4j
public class SecuredSererController {

    @RequestMapping("/secured")
    public String secured() {
        log.info("Inside secured()");
        return "Hello user !!! : " + LocalDateTime.now();
    }
}
