package com.soft1851.springboot.jpa.model.cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/14
 * @Version 1.0
 */
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses",fetch = FetchType.EAGER)
    private List<Student> students;
}
