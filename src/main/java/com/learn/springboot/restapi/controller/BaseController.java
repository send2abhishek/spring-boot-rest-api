package com.learn.springboot.restapi.controller;

import com.learn.springboot.restapi.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class BaseController {

    @Value("${name:demo}")
    private String studentName;

    @GetMapping("/create")
    public Student homePage(){
        return new Student(1,"Abhishek","bangalore");
    }
}
