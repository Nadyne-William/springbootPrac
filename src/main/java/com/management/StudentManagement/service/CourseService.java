package com.management.StudentManagement.service;

import com.management.StudentManagement.model.Course;
import com.management.StudentManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getAllCoursesById(Long courseID){
        Optional<Course> courseList = courseRepository.findById(courseID);
        if (courseList.isPresent()){
            return courseList;
        }else {
            return null;
        }
    }

    public String updateCourseDetails(Long courseId, Course course){
        if (courseRepository.existsById(courseId)){
            Course newCourseDetails = courseRepository.findById(courseId).get();
            newCourseDetails.setCourseName(course.getCourseName());
            newCourseDetails.setCourseDescription(course.getCourseDescription());
            newCourseDetails.setCourseCapacity(course.getCourseCapacity());

            courseRepository.save(newCourseDetails);
            return "Course details updated succesfully";
        }
        return "course with " + courseId + " is not available";
    }

    public String deleteCourseDetails(Long courseID){
        if (courseRepository.existsById(courseID)){
            courseRepository.deleteById(courseID);
            return "Course deleted successfully";
        }
        return "course with " + courseID + " is not available";
    }
}
