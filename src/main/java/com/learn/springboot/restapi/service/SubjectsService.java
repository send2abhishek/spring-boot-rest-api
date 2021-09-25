package com.learn.springboot.restapi.service;

import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.model.Subjects;
import com.learn.springboot.restapi.repository.SubjectsRepository;
import com.learn.springboot.restapi.request.SubjectsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectsService {

    private final SubjectsRepository subjectsRepository;
    private final StudentService studentService;

    @Autowired
    public SubjectsService(SubjectsRepository subjectsRepository, StudentService studentService) {
        this.subjectsRepository = subjectsRepository;
        this.studentService = studentService;
    }

    public Subjects saveSubjects(SubjectsRequest subjectsRequest){
        Student student = studentService.getStudent(subjectsRequest.getStudentId());
        return subjectsRepository.save(new Subjects(subjectsRequest.getName(),student));
    }
}
