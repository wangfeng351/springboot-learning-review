package com.soft1851.springboot.jpa.model.cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description 教师
 * @Author wf
 * @Date 2020/5/13
 * @Version 1.0
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String jobNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;
}
