package com.soft1851.springboot.jpa.service.impl;

import com.soft1851.springboot.jpa.model.cascade.TeacherDetail;
import com.soft1851.springboot.jpa.repository.TeacherDetailRepository;
import com.soft1851.springboot.jpa.service.TeacherDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
@Service
public class TeacherDetailServiceImpl implements TeacherDetailService{
    @Resource
    private TeacherDetailRepository teacherDetailRepository;

    @Override
    public Page<TeacherDetail> findByHobby(TeacherDetail teacherDetail, Pageable pageable) {
        return teacherDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //equal示例
            if (!StringUtils.isEmpty(teacherDetail.getIntroduction())) {
                predicates.add(cb.equal(root.get("introduction"), teacherDetail.getIntroduction()));
            }
            //like示例
            if (!StringUtils.isEmpty(teacherDetail.getRealName())) {
                predicates.add(cb.like(root.get("realName"), "%" + teacherDetail.getRealName()));
            }
            //greaterThan示例
            if (teacherDetail.getUserId() != null) {
                predicates.add(cb.greaterThan(root.get("userId"), teacherDetail.getUserId()));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }
//    @Resource
//    private TeacherDetailRepository teacherDetailRepository;
//
//    @Override
//    public Page<TeacherDetail> findByHobby(TeacherDetail teacherDetail, Pageable pageable) {
//        return teacherDetailRepository.findAll((root, query, cb) ->{
//            List<Predicate> predicates = new ArrayList<Predicate>();
//            //equal示例
//            if (!StringUtils.isEmpty(teacherDetail.getIntroduction())) {
//                predicates.add((Predicate) cb.equal(root.get("hobby"), teacherDetail.getIntroduction()));
//            }
//           //like示例
//            if (!StringUtils.isEmpty(teacherDetail.getRealName())) {
//                predicates.add((Predicate) cb.like(root.get("realName"), "%" + teacherDetail.getRealName() + "%"));
//            }
//            if (teacherDetail.getUserId() != null) {
//                predicates.add((Predicate) cb.greaterThan(root.get("id"), teacherDetail.getId()));
//            }
//            return null;
//        }))
//    }
}
