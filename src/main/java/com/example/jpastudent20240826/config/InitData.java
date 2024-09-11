package com.example.jpastudent20240826.config;

import com.example.jpastudent20240826.model.Student;
import com.example.jpastudent20240826.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Bruce");
        s1.setBornDate(LocalDate.of(2010, 11, 27));
        s1.setBornTime(LocalTime.of(12, 40, 20));

        Student s2 = new Student();
        s2.setName("Tim");
        s2.setBornDate(LocalDate.of(2010, 11, 27));
        s2.setBornTime(LocalTime.of(12, 40, 20));

        studentRepository.save(s1);
        studentRepository.save(s2);
    }
}
