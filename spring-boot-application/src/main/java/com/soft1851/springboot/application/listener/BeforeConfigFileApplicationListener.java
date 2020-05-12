package com.soft1851.springboot.application.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.env.Environment;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/12
 * @Version 1.0
 */
@Slf4j
public class BeforeConfigFileApplicationListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return false;
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            log.info(">>>>>>>>>>>>>>>>>>>>>>> environment.getProperty(\"name\") : " + environment.getProperty("name"));
        }
    }
}
