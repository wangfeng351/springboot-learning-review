package com.soft1851.springboot.jpa.model.cascade;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
@Entity
@Data
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long userId;
    private String realName;
    private String hobby;
    private String introduction;
}
