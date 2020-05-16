package com.soft1851.springboot.task.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/16
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class AsyncTaskServiceTest {
    @Resource
    private AsyncTaskService asyncTaskService;

    @Test
    public void test() {
        asyncTaskService.boiledRice();
        asyncTaskService.cooking();
    }
}