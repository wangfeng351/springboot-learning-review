package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.repository.test1.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 单数据源测试
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
public class singleDataSourceTest {
    @Resource
    private TeacherRepository teacherRepository;

    @Test
    void testInsert() {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Teacher teacher = Teacher.builder()
                    .name("test" + i)
                    .jobNumber("180233311" + i)
                    .build();
            teachers.add(teacher);

        }
        teacherRepository.saveAll(teachers);
    }

    @Test
    void query() {
        //根据姓名查询
        log.info(teacherRepository.findByName("王老师").toString());
        //查询学号少于指定参数的
        log.info(teacherRepository.findByJobNumberLessThan("1802333120").toString());
        //查询学号在指定区间的数据集
        log.info(teacherRepository.findByJobNumberBetweenOrderByJobNumberAsc("1802333110", "1802333120").toString());
    }
}
