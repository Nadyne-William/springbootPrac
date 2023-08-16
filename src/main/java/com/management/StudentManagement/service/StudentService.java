package com.management.StudentManagement.service;

import com.management.StudentManagement.model.Student;
import com.management.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public Student createStudent (Student student){
        System.out.println(student);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        Optional<Student> studentDetail = studentRepository.findById(id);
        return studentDetail.map(Optional::of).orElse(null);
    }

    public String updateStudent(Long id, Student student){
        if (studentRepository.existsById(id)){
            Student newStudent  =  studentRepository.findById(id).get();
            newStudent.setGender(student.getGender());
            newStudent.setLastName(student.getLastName());
            newStudent.setFirstName(student.getFirstName());

            studentRepository.save(newStudent);
            return "Record updated successfully";
        }
        return "Record with that id not found";
    }

    public String deleteStudent(Long id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "record deleted successfully";
        }
        return "student with that id hasn't been found";
    }

}
