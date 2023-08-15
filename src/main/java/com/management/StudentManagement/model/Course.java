package com.management.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long courseId;

    private String courseName;

    private String courseDescription;

    private Integer courseCapacity;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> student = new HashSet<>();
}
