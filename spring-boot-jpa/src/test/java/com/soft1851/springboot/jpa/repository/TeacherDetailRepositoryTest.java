package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.model.cascade.TeacherDetail;
import com.soft1851.springboot.jpa.model.cascade.TeacherInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class TeacherDetailRepositoryTest {
    @Autowired
    private TeacherDetailRepository teacherDetailRepository;

    @Test
    public void save() {
        List<TeacherDetail> teacherDetails = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TeacherDetail teacherDetail = new TeacherDetail();
            teacherDetail.setRealName("王锋" + i);
            teacherDetail.setIntroduction("我是一个耿直boy" + i);
            teacherDetail.setUserId((long) (i+ 1111));
            teacherDetail.setHobby("吃饭睡觉打豆豆");
            teacherDetails.add(teacherDetail);
        }
        teacherDetailRepository.saveAll(teacherDetails);
    }

    @Test
    public void findTeacherDetailInfo() {
        List<TeacherInfo> teacherInfos = new ArrayList<>();
        List<Object> list = teacherDetailRepository.findDetailInfo("王锋0");
        for (Object o : list) {
            Object[] rowArray = (Object[]) o;
            TeacherInfo info = new TeacherInfo();
            info.setHobby((String) rowArray[0]);
            info.setIntroduction((String) rowArray[1]);
            info.setClazzName((String) rowArray[2]);
            info.setName((String) rowArray[3]);
            teacherInfos.add(info);
        }
        System.out.println(teacherInfos.toString());
//        for (TeacherInfo teacherInfo : list) {
//            System.out.println(teacherInfo);
//        }
    }
}