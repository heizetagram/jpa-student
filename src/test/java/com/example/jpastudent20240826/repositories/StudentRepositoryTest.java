package com.example.jpastudent20240826.repositories;

import com.example.jpastudent20240826.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void testOneBruce() {
        List<Student> students = studentRepository.findAllByName("Tim");
        assertEquals(1, students.size());
    }

    @BeforeEach
    void testOneViggo() {
        Student s1 = new Student();
        s1.setName("Viggo");
        s1.setBornDate(LocalDate.of(2010, 11, 11));
        studentRepository.save(s1);
        List<Student> students = studentRepository.findAllByName("Viggo");
        assertEquals(1, students.size());
    }

}