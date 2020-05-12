package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/12
 * @Version 1.0
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     *  解析方法名创建查询：根据摘要查询
     *
     * @param msgText
     * @param msgSummary
     * @return
     */
    Message findByMsgTextAndMsgSummary(String msgText, String msgSummary);

    /**
     * 根据msgSummary查询指定数据
     *
     * @param msgSummary
     * @return
     */
    Message findByMsgSummaryEquals(String msgSummary);

    /**
     * 查询大于等于该id的数据
     *
     * @param msgId
     * @return
     */
    List<Message> findByMsgIdGreaterThanEqual(int msgId);

    /**
     * 查询指定id之间的数据
     *
     * @param start
     * @param end
     * @return
     */
    List<Message> findByMsgIdBetween(int start, int end);

    /**
     * 查询不含有此字符的数据
     *
     * @param msgText
     * @return
     */
    List<Message> findByMsgTextNotLike(String msgText);
}
