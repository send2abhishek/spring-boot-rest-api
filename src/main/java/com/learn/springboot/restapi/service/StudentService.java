package com.learn.springboot.restapi.service;

import com.learn.springboot.restapi.exceptionhandling.StudentNotFoundException;
import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.model.StudentResponse;
import com.learn.springboot.restapi.repository.StudentRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "updateAt"));
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(new Student(student.getName(), student.getEmail()));
    }

    public Student updateStudent(@NonNull Student student) {

        Student studentObj = studentRepository.findById(student.getId()).get();

        if (student.getEmail() != null) {
            studentObj.setEmail(student.getEmail());
            studentObj.setUpdateAt(new Timestamp(new Date().getTime()));
            studentRepository.save(studentObj);
        }

        return student;

    }

    public String deleteStudent(int id){
        studentRepository.deleteById(id);
        return "student deleted";
    }

    public List<StudentResponse> getStudentByName(String name){
        return studentRepository.findByName(name);
    }
}
