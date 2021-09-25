package com.learn.springboot.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = true)
    @JsonIgnore(value = true)
    private Student student;

    public Subjects(String name, Student student) {
        this.name = name;
        this.student = student;
    }
}
