package com.soft1851.springboot.task.service.Impl;

import com.soft1851.springboot.task.service.MailService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/15
 * @Version 1.0
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
        log.info("邮件发送成功");

    }

    @SneakyThrows
    @Override
    public void sendSimpleHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        //设置multipart为true,表示支持发送消息时支持附件，如果中文乱码，可设置第三个参数为编码格式
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        //发送方的邮件地址
        messageHelper.setFrom(from);
        //接收者邮件地址
        messageHelper.setTo(to);
        //设置标题
        messageHelper.setSubject(subject);
        // 设置内容，true 表示HTML标签生效
        messageHelper.setText(content, true);
        mailSender.send(message);
        log.info("【HTML邮件】成功发送！to={}", to);
    }

    @SneakyThrows
    @Override
    public void sendSimpleImageMail(String to,String subject, String content, Map<String, String> imgMap) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
        // 添加图片
        for (Map.Entry<String, String> entry : imgMap.entrySet()) {
            //获取系统资源
            FileSystemResource resource = new FileSystemResource(new File(entry.getValue()));
            if (resource.exists()) {
                //添加内联元素
                messageHelper.addInline(entry.getKey(), resource);
            }
        }
        mailSender.send(message);
        log.info("【图片邮件】发送成功");
    }

    @SneakyThrows
    @Override
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
        // 添加附件
        for (String filePath : fileArr) {
            FileSystemResource fileResource = new FileSystemResource(new File(filePath));
            if (fileResource.exists()) {
                String fileName = fileResource.getFilename();
                assert fileName != null;
                messageHelper.addAttachment(fileName, fileResource );
            }
        }
        mailSender.send(message);
        log.info("附件发送成功！！！ ");
    }

}
