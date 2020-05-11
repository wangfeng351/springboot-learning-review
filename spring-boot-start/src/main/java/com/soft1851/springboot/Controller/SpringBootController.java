package com.soft1851.springboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 标准的Spring Boot RESTController
 * @Author wf
 * @Date 2020/5/11
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class SpringBootController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
