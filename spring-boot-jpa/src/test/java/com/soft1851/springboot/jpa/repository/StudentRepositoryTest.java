package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void getByStudentName() {
        log.info(studentRepository.getByStudentName("学生test2").toString());
    }

    @Test
    void deleteSingleById() {
        log.info("删除的记录数：" + studentRepository.deleteSingleById(2));
    }

    @Test
    void updateSingleById() {
        log.info("更新影响行数：" + studentRepository.updateSingleById(3, "王锋"));
    }

    @Test
    void test() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder().jobNumber("180233312" + i).name("学生test" + i).build();
            students.add(student);
        }
        List<Student> list = studentRepository.saveAll(students);
    }

    @Test
    void getByClazzIdOrderByJobNumberAsc() {
        int page = 1, size = 2;
        Pageable pageable = PageRequest.of(page, size, Sort.by("jobNumber"));
        Slice<Student> students = studentRepository.findByName("学生test4", pageable);
        Page page1 = studentRepository.getByJobNumber("1802333118", pageable);
        log.info(("总页数：" + page1.getTotalPages()));
    }

    @Test
    void findByName() {
    }
}