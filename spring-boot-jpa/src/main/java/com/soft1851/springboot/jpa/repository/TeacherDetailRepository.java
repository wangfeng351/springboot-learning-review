package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.TeacherDetail;
import com.soft1851.springboot.jpa.model.cascade.TeacherInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
public interface TeacherDetailRepository extends JpaSpecificationExecutor<TeacherDetail>, JpaRepository<TeacherDetail, Long> {

    /**
     * 多表联查
     * @param realName
     * @return
     */
    @Query(value = "SELECT u.hobby as hobby, u.introduction as introduction, " +
            "b.name as name FROM TeacherDetail u, Teacher b " +
            "WHERE u.userId = b.teacherId and u.realName = ?1")
    List<Object> findDetailInfo(String realName);
}
