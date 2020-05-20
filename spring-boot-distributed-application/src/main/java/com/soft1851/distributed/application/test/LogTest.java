package com.soft1851.distributed.application.test;

import org.apache.log4j.Logger;
/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/20
 * @Version 1.0
 */
public class LogTest {

    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(LogTest.class);
        final Logger saveUserLog = Logger.getLogger("saveUserLog");

        if (logger.isDebugEnabled()) {
            logger.debug("debug");
        }

        logger.info("info");
        logger.error("error");

        saveUserLog.info("张三,男,26岁,北京大学,2018-05-19,学霸");

    }
}
