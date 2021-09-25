package com.learn.springboot.restapi.controller;


import com.learn.springboot.restapi.model.Subjects;
import com.learn.springboot.restapi.request.SubjectsRequest;
import com.learn.springboot.restapi.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectsService subjectsService;

    @Autowired
    public SubjectController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }


    @PostMapping("/create")
    public ResponseEntity<Subjects> saveSubject(@RequestBody SubjectsRequest subjectsRequest){

        return new ResponseEntity<>(subjectsService.saveSubjects(subjectsRequest), HttpStatus.OK);
    }
}
