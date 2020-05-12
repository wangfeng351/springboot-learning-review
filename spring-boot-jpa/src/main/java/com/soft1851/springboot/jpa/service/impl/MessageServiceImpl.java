package com.soft1851.springboot.jpa.service.impl;

import com.soft1851.springboot.jpa.dao.MessageRepository;
import com.soft1851.springboot.jpa.model.Message;
import com.soft1851.springboot.jpa.service.MessageService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/12
 * @Version 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void batchSave(List<Message> messages) {
        messageRepository.saveAll(messages);
    }

    @Override
    public void delete(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void batchDelete(List<Message> messages) {
        messageRepository.deleteInBatch(messages);
    }

    @Override
    public void deleteAll() {
        messageRepository.deleteAllInBatch();
    }

    @Override
    public void update(Message message) {
        messageRepository.saveAndFlush(message);
    }

    /**
     * 获取持久化管理器
     */
    @PersistenceContext
    private EntityManager em;

    @Override
    public void batchUpdate(List<Message> messages) {
        messages.forEach(message -> {
            em.merge(message);
        });
        em.flush();
        em.clear();
    }

    @Override
    public long count() {
        return messageRepository.count();
    }

    @Override
    public Message getMessage(Integer id) {
        //findOne的速度快于findById
        Optional<Message> msg = messageRepository.findById(id);
        //Optional<Message> msg = messageRepository.findOne(Example.of(Message.builder().msgId(id).build()))
        return msg.orElse(null);
    }

    @Override
    public List<Message> getAll() {
        //findOne的速度快于findById
        return messageRepository.findAll();
    }
}
