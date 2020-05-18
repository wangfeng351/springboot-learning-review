package com.soft1851.springboot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
//@ComponentScan("com.soft1851.springboot.task.service")
public class SpringbootTaskApplication {

    public static void main(String[] args) {
        /** 配置加解密秘钥，与配置文件的密文分开放 */
        System.setProperty("jasypt.encryptor.password", String.valueOf(123));
        SpringApplication.run(SpringbootTaskApplication.class, args);
    }

}
