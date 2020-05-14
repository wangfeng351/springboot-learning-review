package com.soft1851.springboot.jpa.controller;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.repository.test1.TeacherRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Resource
    private TeacherRepository teacherRepository;

    @GetMapping()
    public List<Teacher> findByNameOrClazzName(@Param("name") String name) {
        return teacherRepository.findByName(name);
    }
}
