package com.soft1851.springboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/11
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping()
    public String hello() {
        return "hello, everyone!!!";
    }

    @GetMapping(value = "/name")
    public String hello1(@PathParam("greeting") String greeting) {
        return "hello, " + greeting;
    }

    @GetMapping(value = "/{greeting}")
    public String hello2(@PathVariable String greeting) {
        return "hello, " + greeting;
    }
}
