package com.management.StudentManagement.controller;

import com.management.StudentManagement.model.Enrollment;
import com.management.StudentManagement.service.CourseService;
import com.management.StudentManagement.service.EnrollmentService;
import com.management.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/enrollmentsTest")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll/{studentId}/{courseId}")
    public String enrollStudentsInCourse(@PathVariable(name = "studentId") Long studentId, @PathVariable(name = "courseId")Long courseId){
        enrollmentService.enrollStudentsInCourse(studentId, courseId);
        return "enrollment has been succesfull";
    }


}
