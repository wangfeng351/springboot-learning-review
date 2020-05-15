package com.soft1851.springboot.task.task1;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@Component
public class Task1 {
    private int count = 0;

    /**
     * 每5秒执行一次
     */
    //@Scheduled(cron = "5 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running " + (count++));
    }
}
