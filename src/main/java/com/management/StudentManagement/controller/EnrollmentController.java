package com.management.StudentManagement.controller;

import com.management.StudentManagement.model.Enrollment;
import com.management.StudentManagement.service.CourseService;
import com.management.StudentManagement.service.EnrollmentService;
import com.management.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/enrollmentsTest")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public String enrollStudentsInCourse(Long studentId, Long courseId){
        enrollmentService.enrollStudentsInCourse(studentId, courseId);
        return "enrollment has been succesfull";
    }


}
