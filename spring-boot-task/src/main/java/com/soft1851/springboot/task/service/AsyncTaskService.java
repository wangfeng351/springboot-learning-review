package com.soft1851.springboot.task.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/16
 * @Version 1.0
 */
@Slf4j
@Service
public class AsyncTaskService {
    @Async
    public void asyncTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
    }

    public void boiledRice() {
        try {
            Thread.sleep(5000);
            System.out.println("煮米饭中 ！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cooking() {
        try {
            Thread.sleep(5000);
            System.out.println("正在烧菜！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
