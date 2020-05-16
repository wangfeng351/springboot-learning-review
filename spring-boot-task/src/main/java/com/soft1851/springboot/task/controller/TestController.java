package com.soft1851.springboot.task.controller;

import com.soft1851.springboot.task.entity.Cron;
import com.soft1851.springboot.task.repository.CronRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/api")
public class TestController {

    @GetMapping(value = "/hello")
    public String test() {
        return "hello";
    }

    @Resource
    protected CronRepository cronRepository;
    private static int i = 0;
    /**
     * 线程池任务调度类，能够开启线程池进行任务调度
     */

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    //定义线程池任务调度器
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    //接受任务的返回结果
    private static ConcurrentHashMap<String, ScheduledFuture> map = new ConcurrentHashMap<>();
    private ScheduledFuture<?> future;

    @SneakyThrows
    @GetMapping("/start/{id}")
    public String start(@PathVariable int id) {
        String cron = cronRepository.findCronByCronIdEquals(id).getCron();
        /*schedule（）方法会创建一个定时计划ScheduleFuture
         * 两个参数, Runnable:线程接口类，CronTrigger(定时任务触发器)
         */
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron));
        //map.put("1", future);
        map.put(String.valueOf(id), future);
        log.info("定时任务启动");
        return "定时任务启动";
    }

    @GetMapping("/stop/{id}")
    public String stopCron(@PathVariable("id") String id) {
        ScheduledFuture<?> future = map.get(id);
        if (future != null) {
            future.cancel(true);
        }
        map.remove(id);
        log.info("定时任务停止");
        return "定时任务停止";
    }

    @PostMapping("/change")
    public String updateCron(@RequestBody Cron cron) {
        stopCron(String.valueOf(cron.getCronId()));
        map.remove(String.valueOf(cron.getCronId()));
        cronRepository.updateCronById(cron.getCron(), cron.getCronId());
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron.getCron()));
        map.put(String.valueOf(cron.getCronId()), future);
        return "修改定时任务设置";
    }


    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log.info("我的定时任务：" + LocalDateTime.now() );
        }
    }

}
