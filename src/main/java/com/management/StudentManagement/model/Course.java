package com.management.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long courseId;


    private String courseName;


    private String courseDescription;


    private int courseCapacity;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}
