package com.soft1851.springboot.task.repository;

import com.soft1851.springboot.task.entity.Cron;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/17
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class CronRepositoryTest {
    @Resource
    private CronRepository cronRepository;

    @Test
    void findCronByCronIdEquals() {
        System.out.println(cronRepository.findCronByCronIdEquals(1));;
    }
}