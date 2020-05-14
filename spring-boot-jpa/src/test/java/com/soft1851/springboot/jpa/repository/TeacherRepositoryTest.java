package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.repository.test1.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private  ClazzRepository clazzRepository;

    private String name = "test1";
    private String jobNumber = "1802333112";
    private String clazzName = "软件1852";
    @Test
    void findTeacherByJobNumberAndClazzName() {
        log.info(teacherRepository.findTeacherByJobNumberAndName(jobNumber, clazzName).toString());
    }

    @Test
    void findByNameOrClazzName() {
        log.info(teacherRepository.findByName(name).toString());
    }

    @Test
    void findByJobNumberBetweenOrderByJobNumberAsc() {
        log.info(teacherRepository.findByJobNumberBetweenOrderByJobNumberAsc("1802333112", "1802333115").toString());
    }

    @Test
    void findByJobNumberLessThan() {
        log.info(teacherRepository.findByJobNumberLessThan("1802333113").toString());
    }

    @Test
    void findByClazzNameIsNull() {
        log.info(teacherRepository.findByClazzNameIsNull().toString());
    }

    @Test
    void updateClazzName() {
        log.info("修改记录：" + teacherRepository.updateClazzName("软件1851",1));
    }

    @Test
    void insertSingle() {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            /*Teacher teacher = Teacher.builder().name("测试" + 1)
                    .clazzName("软件185" + i)
                    .jobNumber("18023311" + i)
                    .createTime(Timestamp.valueOf(LocalDateTime.now()))
                    .build();*/
            String name = "test" + i;
            String clazzName = "软件185" + i;
            String jobNumber = "180233311" + i;
            Timestamp time = Timestamp.valueOf(LocalDateTime.now());
            teacherRepository.insertTeacher(name, jobNumber, clazzName, time);
        }
    }
}