package com.soft1851.springboot.application.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description 应用上下文初始化
 * @Author wf
 * @Date 2020/5/12
 * @Version 1.0
 */
//启动顺序
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HelloWorldApplicationInitializer <C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C c) {
        log.info(">>>>>>>>>>>>>>>>>>>> 初始化applicationContext，ConfigurableApplicationContext.id = " + c.getId());
    }
}
