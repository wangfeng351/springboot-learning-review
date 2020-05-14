package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
public interface ClazzRepository extends JpaRepository<Clazz, Long> {

    /**
     * 根据姓名查询教师信息
     * @param name
     * @return
     */
    Clazz findByName(String name);
}
