package com.learn.springboot.restapi.response;

import com.learn.springboot.restapi.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentSaveResponse {

    private String message;
    private Student student;

}
