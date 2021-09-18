package com.learn.springboot.restapi.controller;

import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.response.StudentSaveResponse;
import com.learn.springboot.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<StudentSaveResponse> save(@RequestBody Student student) {

        return new ResponseEntity<StudentSaveResponse>
                (new StudentSaveResponse("student created", studentService.saveStudent(student)), HttpStatus.CREATED);

    }
}
