package com.management.StudentManagement.service;

import com.management.StudentManagement.model.Course;
import com.management.StudentManagement.model.Enrollment;
import com.management.StudentManagement.model.Student;
import com.management.StudentManagement.repository.CourseRepository;
import com.management.StudentManagement.repository.EnrollmentRepository;
import com.management.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    public Enrollment enrollStudentsInCourse(Long studentId, Long courseId){


        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null){
            throw new IllegalArgumentException("Student or course not found");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        System.out.println(enrollment);
        return enrollmentRepository.save(enrollment);
    }
}
