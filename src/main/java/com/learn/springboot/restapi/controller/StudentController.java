package com.learn.springboot.restapi.controller;

import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.model.StudentResponse;
import com.learn.springboot.restapi.response.StudentSaveResponse;
import com.learn.springboot.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    public ResponseEntity<List<Student>> findAllStudent() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Student> findOne(@PathVariable int id) {
        System.out.println("App id is "+id);
        return new ResponseEntity<Student>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentSaveResponse> save(@RequestBody Student student) {
        return new ResponseEntity<StudentSaveResponse>
                (new StudentSaveResponse("student created", studentService.saveStudent(student)), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentSaveResponse> update(@RequestBody Student student) {
        return new ResponseEntity<StudentSaveResponse>
                (new StudentSaveResponse("student updated", studentService.updateStudent(student)), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> update(@PathVariable int id) {
        return new ResponseEntity<String>(studentService.deleteStudent(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> getDetails(){
        HashMap<String,Object> responseEntity=new LinkedHashMap<>();
        responseEntity.put("name","Abhishek Aryan");
        responseEntity.put("id",1);
        responseEntity.put("student",new Student("Abhishek","send2abhishek@live.com"));
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<StudentResponse>> findOne(@PathVariable String name) {
        return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
    }
}
