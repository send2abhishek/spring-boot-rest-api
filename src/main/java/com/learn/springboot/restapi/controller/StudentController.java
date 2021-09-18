package com.learn.springboot.restapi.controller;

import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

   private final StudentService studentService;

   @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> homePage() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
