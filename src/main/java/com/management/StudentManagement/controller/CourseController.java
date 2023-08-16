package com.management.StudentManagement.controller;

import com.management.StudentManagement.model.Course;
import com.management.StudentManagement.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/courseTesting")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping()
    public Course createCourse(@Valid @RequestBody Course course){
        return courseService.createCourse(course);
    }

    @GetMapping()
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable(name = "id") Long courseId){
        return courseService.getAllCoursesById(courseId);
    }

    @PutMapping("/{id}")
    public String updateCourseDetails(@PathVariable(name = "id")Long courseID, @RequestBody @Valid Course course){
        return courseService.updateCourseDetails(courseID, course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable(name = "id")Long courseId){
        return courseService.deleteCourseDetails(courseId);
    }
}
