package com.soft1851.springboot.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {

    @GetMapping(value = "/hello")
    public String test() {
        return "hello";
    }
}
