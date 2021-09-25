package com.learn.springboot.restapi.repository;

import com.learn.springboot.restapi.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects,Integer> {
}
