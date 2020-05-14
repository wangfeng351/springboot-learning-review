package com.soft1851.springboot.jpa.repository.test2;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
public interface TeacherRepository1 extends JpaRepository<Teacher, Long> {

    /**
     * 根据工号与所带班级查询指定教师
     * @param jobNumber
     * @param clazzName
     * @return
     */
    Teacher findTeacherByJobNumberAndName(String jobNumber, String clazzName);

    /**
     * 使用Or查询数据视图
     * @param name
     * @return
     */
    List<Teacher> findByName(String name);

    /**
     * 使用between查询两学号中间的数据集
     * @param start
     * @param end
     * @return
     */
    List<Teacher> findByJobNumberBetweenOrderByJobNumberAsc(String start, String end);


    /**
     * 查询JobNumber小于指定参数的数据集
     * @param jobNumber
     * @return
     */
    List<Teacher> findByJobNumberLessThan(String jobNumber);

    /**
     * 查询clazzName为空的数据集
     * @return
     */
    List<Teacher> findByClazzNameIsNull();

    /**
     * 根据id修改班级名称
     * @param clazzName
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE teacher SET clazz_name = ?1 WHERE  teacher_id=?2", nativeQuery = true)
    int updateClazzName(String clazzName, long id);


    /**
     * 自定义插入
     * @param name
     * @param jobNumber
     * @param clazzName
     * @param createTime
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "INSERT INTO teacher(name, job_number, clazz_name, create_time) VALUES (:name, :jobNumber, :clazzName, :createTime)", nativeQuery = true)
    int insertTeacher(@Param("name") String name, @Param("jobNumber") String jobNumber, @Param("clazzName") String clazzName, @Param("createTime") Timestamp createTime);
}

