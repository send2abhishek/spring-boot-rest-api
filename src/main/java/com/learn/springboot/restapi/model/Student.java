package com.learn.springboot.restapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private int id;
    private String name;
    private String address;

    public Student(int id,String name, String address) {
        this.id=id;
        this.name = name;
        this.address = address;
    }
}
