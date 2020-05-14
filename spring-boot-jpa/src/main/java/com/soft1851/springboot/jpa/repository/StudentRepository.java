package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * 自定义查询
     * @param name
     * @return
     */
    @Query(value = "SELECT u FROM Student u WHERE  u.name= :name")
    List<Student> getByStudentName(@Param("name") String name);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "DELETE FROM Student WHERE student_id= :id")
    int deleteSingleById(@Param("id") long id);

    /**
     * 根据id修改数据
     *
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE Student SET name=?2 WHERE id=?1 ")
    int updateSingleById(long id, String name);

    /**
     * 分页查询，用Page接收
     *
     * @param pageable
     * @return
     */
    Page<Student> getByJobNumber(String jobNumber, Pageable pageable);

    /**
     * 分页查询，用slice接收
     *
     * @param name
     * @param pageable
     * @return
     */
    Slice<Student> findByName(String name, Pageable pageable);

    /**
     * 自定义根据班课id查询
     * @param id
     * @return
     */
    @Query(value = "SELECT student_id, name, job_number FROM student WHERE clazz_id=?1", nativeQuery = true)
    List<Student> findByClazzId(int id);
}
