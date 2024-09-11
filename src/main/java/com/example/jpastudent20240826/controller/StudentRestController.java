package com.example.jpastudent20240826.controller;

import com.example.jpastudent20240826.model.Student;
import com.example.jpastudent20240826.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student student = new Student();
        student.setBornDate(LocalDate.now());
        student.setBornTime(LocalTime.now());
        student.setName("Bob");

        studentRepository.save(student);
        student.setName("Auto id: " + student.getId());
        studentRepository.save(student);

        return studentRepository.findAll();
    }

    @GetMapping("students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }
}