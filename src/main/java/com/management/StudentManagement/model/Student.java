package com.management.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "studentDetails")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @JsonIgnore
    private Long id;


    private String firstName;


    private String lastName;


    private String gender;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    private List<Course> courses;
}
