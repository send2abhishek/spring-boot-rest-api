package com.learn.springboot.restapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    // this will insert default timestamp

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    
    @Column(name = "updated_at")
    @CreationTimestamp
    private Timestamp updateAt;

    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Subjects> subjects;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
