package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.cascade.Course;
import com.soft1851.springboot.jpa.model.cascade.Student;
import com.soft1851.springboot.jpa.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
public class CascadeRepositoryTest {
    @Resource
    private StudentRepository studentRepository;

    @Test
    public void oneToOne() {

    }

    @Test
    public void manyToOne() {

    }

    @Test
    public void manyToMany() {
        List<Student> students = studentRepository.findByClazzId(1);
        students.forEach(student -> {
            System.out.println(student.getStudentId() + "," + student.getName());
            List<Course> courseList = student.getCourses();
            courseList.forEach(course -> {
                System.out.println(course.getId() + "," + course.getName());
            });
        });
    }
}
