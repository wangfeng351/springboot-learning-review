package com.soft1851.springboot.task.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/15
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleTextMail() {
        String to = "1244353765@qq.com";
        String content = "hello, 这是邮箱测试发送的信息";
        String subject = "Springboot 发送简单文本邮件";
        mailService.sendSimpleTextMail(to, subject, content);
    }

    @Test
    void sendSimpleHtmlMail() {
        String to = "1244353765@qq.com";
        String content = "<h3>hello, 这是邮箱测试发送的信息</h3>";
        String subject = "Springboot 发送html格式文本邮件";
        mailService.sendSimpleHtmlMail(to, subject, content);
    }

    @Test
    void sendAttachmentMail() {
        String to = "1244353765@qq.com";
        String content = "<h3>hello, 这是邮箱测试发送的信息</h3>";
        String subject = "Springboot 发送附件邮件";
        String filePath = "D:\\爱了爱了.png";
        mailService.sendAttachmentMail(to, subject, content, filePath);
    }

    @Test
    void sendImgMail() {
        String to = "1244353765@qq.com";
        //cid为自己设置的资源的键(keyId)
        String content = "<h3>发送的图片邮件</br><img src=\"cid:img01\"/></h3>";
        String subject = "Springboot 发送图片邮件";
        Map<String, String> imgMap = new HashMap<>();
        String filePath = "D:\\爱了爱了.png";
        imgMap.put("img01", filePath);
        mailService.sendSimpleImageMail(to, subject, content, imgMap);
    }
}