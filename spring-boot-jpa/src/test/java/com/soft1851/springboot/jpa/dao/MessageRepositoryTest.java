package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import com.soft1851.springboot.jpa.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/12
 * @Version 1.0
 */
@Slf4j
@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void findByMsgTextAndMsgSummary() {
        log.info(messageRepository.findByMsgTextAndMsgSummary("JPQL", "沉迷学习").toString());
    }

    @Test
    public void findByMsgSummaryEquals() {
        log.info(messageRepository.findByMsgSummaryEquals("SpringBoot").toString());
    }

    @Test
    public void findByMsgIdGreaterThanEqual() {
        log.info(messageRepository.findByMsgIdGreaterThanEqual(5).toString());
    }

    @Test
    public void findByMsgIdBetween() {
        log.info(messageRepository.findByMsgIdBetween(5,7).toString());
    }

    @Test
    public void findByMsgTextNotLike() {
        log.info(messageRepository.findByMsgTextNotLike("Flutter").toString());
    }
}