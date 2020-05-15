package com.soft1851.springboot.task.service;

import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/15
 * @Version 1.0
 */
public interface MailService {
    /**
     * 发送简单的文本
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTextMail(String to, String subject, String content);

    /**
     * 发送一个简单的html
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleHtmlMail(String to, String subject, String content);

    /**
     * 发送一个生日卡片
     * @param to
     * @param content
     * @param imgMap
     */
    void sendSimpleImageMail(String to,String subject, String content, Map<String, String> imgMap);

    /**
     * 附件发送
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     */
    void sendAttachmentMail(String to, String subject, String content, String... fileArr);
}
