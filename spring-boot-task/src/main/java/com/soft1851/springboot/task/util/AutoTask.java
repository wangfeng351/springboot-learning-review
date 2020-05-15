package com.soft1851.springboot.task.util;

import com.soft1851.springboot.task.repository.CronRepository;
import com.soft1851.springboot.task.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/15
 * @Version 1.0
 */
@Slf4j
@Component
public class AutoTask implements SchedulingConfigurer {
    @Resource
    protected MailService mailService;
    @Resource
    protected CronRepository cronRepository;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(this::process,
                triggerContext -> {
                    //这里就先查询子id为1的cron
                    String cron = cronRepository.findCronByCronIdEquals(1).getCron();
                    log.info(cron);
                    if (cron.isEmpty()) {
                        log.info("cron 为空");
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
    }

    private void process() {
        String content = "<h3>亲爱的xxx，小Q在这里给你送上祝福，生日快乐</br><img src=\"cid:img01\"/></h3>";
        String subject = "生日贺卡";
        String to = "1244353765@qq.com";
        Map<String, String> map = new HashMap<>();
        String filePath = "D:\\生日卡片.png";
        map.put("img01", filePath);
        mailService.sendSimpleImageMail(to, subject, content, map);
    }
}
