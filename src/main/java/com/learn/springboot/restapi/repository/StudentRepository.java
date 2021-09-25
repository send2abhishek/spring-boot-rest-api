package com.learn.springboot.restapi.repository;

import com.learn.springboot.restapi.model.Student;
import com.learn.springboot.restapi.model.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<StudentResponse> findByName(String name);
    List<Student> findByNameAndEmail(String name, String email);
    List<StudentResponse> findAllBy();
    List<StudentResponse> findByNameAndAddressPinCodeAndSubjectsName(String name,int pinCode,String subjectName);
}
