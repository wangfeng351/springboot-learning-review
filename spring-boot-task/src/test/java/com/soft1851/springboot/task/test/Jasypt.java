package com.soft1851.springboot.task.test;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/17
 * @Version 1.0
 */
@SpringBootTest
public class Jasypt {

    @Resource
    private  StringEncryptor stringEncryptor;
    /**
     * 测试jasypt加密解密
     */
    @Test
    public void testJasypt() {
        String encryptPwd = stringEncryptor.encrypt("root");
        System.out.println("加密:：" + encryptPwd);
        System.out.println("解密：" + stringEncryptor.decrypt(encryptPwd));
    }
}
