package com.management.StudentManagement.controller;

import com.management.StudentManagement.model.Student;
import com.management.StudentManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/studentsTest")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping()
    public Student createStudent(Student student){
        return studentService.createStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudents(Student student){
        return studentService.getAllStudents(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable(name = "id") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{id}")
    public String updateStudentDetails(@PathVariable(name = "id") Long studentId, @Valid @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentDetails(@PathVariable(name = "id") Long studentId){
        return studentService.deleteStudent(studentId);
    }

}