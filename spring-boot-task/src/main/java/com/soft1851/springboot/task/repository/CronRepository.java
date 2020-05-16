package com.soft1851.springboot.task.repository;

import com.soft1851.springboot.task.entity.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/15
 * @Version 1.0
 */
public interface CronRepository extends JpaRepository<Cron, Integer> {

    /**
     * 根据cronId 查询
     * @param cronId
     * @return
     */
    Cron findCronByCronIdEquals(int cronId);

    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE cron SET cron=?1 WHERE cron_id=?2", nativeQuery = true)
    void updateCronById(String cron, int id);
}
