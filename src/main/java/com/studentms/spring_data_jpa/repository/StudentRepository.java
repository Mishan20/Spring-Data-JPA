package com.studentms.spring_data_jpa.repository;

import com.studentms.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update, and delete operation on objects.
public interface StudentRepository extends JpaRepository<Student, Long>{
    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,String lastName);
}
