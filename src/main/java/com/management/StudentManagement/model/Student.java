package com.management.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "student_details")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @JsonIgnore
    private Long id;


    private String firstName;


    private String lastName;


    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_student_id", referencedColumnName = "student_id")
    private List<Course> course;
}
