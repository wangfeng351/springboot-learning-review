package com.soft1851.springboot.task.config;

import com.soft1851.springboot.task.filter.TrustedEndpointsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/16
 * @Version 1.0
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 内部端口
    @Value("${server.trustedPort:null}")
    private String trustedPort;

    // 内部接口 URL 路径前缀
    @Value("${server.trustedPathPrefix:null}")
    private String trustedPathPrefix;

    @Bean
    public FilterRegistrationBean<TrustedEndpointsFilter> trustedEndpointsFilter() {
        return new FilterRegistrationBean<>(new TrustedEndpointsFilter(trustedPort, trustedPathPrefix));
    }
}