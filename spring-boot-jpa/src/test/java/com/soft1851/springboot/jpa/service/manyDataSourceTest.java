package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.repository.test1.TeacherRepository;
import com.soft1851.springboot.jpa.repository.test2.TeacherRepository1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
public class manyDataSourceTest {
    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private TeacherRepository1 teacherRepository1;

    @Test
    public void save() {
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
    public void query() {
        List<Teacher> list1 = teacherRepository.findAll();
        log.info(list1.toString());
        List<Teacher> list2 = teacherRepository1.findAll();
        log.info(list2.toString());
    }
}
