package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class ClazzRepositoryTest {
    @Resource
    private ClazzRepository clazzRepository;

    @Test
    void findByName() {
        Clazz clazz = clazzRepository.findByName("软件1851");
        log.info(clazz.toString());
    }
}