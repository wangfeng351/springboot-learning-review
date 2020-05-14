package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.cascade.TeacherDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
public interface TeacherDetailService {
    /**
     * 复杂分页查询
     * @param teacherDetail
     * @param pageable
     * @return
     */
    Page<TeacherDetail> findByHobby(TeacherDetail teacherDetail, Pageable pageable);
}
