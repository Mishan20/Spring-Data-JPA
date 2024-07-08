package com.studentms.spring_data_jpa.repository;

import com.studentms.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update, and delete operation on objects.
public interface StudentRepository extends JpaRepository<Student, Long>{
}
