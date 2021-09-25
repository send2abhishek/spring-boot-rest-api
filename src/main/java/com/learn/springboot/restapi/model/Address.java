package com.learn.springboot.restapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String streetName;
    private int pinCode;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;


    @Column(name = "updated_at")
    @CreationTimestamp
    private Timestamp updateAt;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    @JsonIgnore(value = true)
    private Student student;

    public Address(String streetName, int pinCode,Student student) {
        this.streetName = streetName;
        this.pinCode = pinCode;
        this.student=student;
    }


}
