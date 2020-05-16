package com.soft1851.springboot.task.config;

import com.soft1851.springboot.task.filter.TrustedEndpointsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/16
 * @Version 1.0
 */
public class WebMvcConfigurer {

    //内部端口
    @Value("${server.trustedPost}")
    private String trustedPost;

    //内部接口 URL路径前缀
    @Value("${server.trustedPathPrefix}")
    private String trustedPathPrefix;

    @Bean
    public FilterRegistrationBean<TrustedEndpointsFilter> trustedEndpointsFilter() {
        return new FilterRegistrationBean<>(new TrustedEndpointsFilter(trustedPost, trustedPathPrefix));
    }
}
