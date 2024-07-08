package com.studentms.spring_data_jpa.repository;

import com.studentms.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired // This annotation is used to inject the dependency automatically.
    private StudentRepository studentRepository;

    @Test // This annotation is used to indicate that the method is a test method.
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ishan@gmail.com")
                .firstName("Ishan")
                .lastName("Senanayaka" )
                .guardianName("Nimal Senanayaka")
                .guardianEmail("nimal@gmail.com")
                .guardianMobile("0771234567")
                .build();

        studentRepository.save(student);
    }

}