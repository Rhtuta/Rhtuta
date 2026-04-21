package com.cfs.JPAP02.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
//@Table(name = "courses")//to change table table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("students")
    public Set<Student> students =new HashSet<>();
}
