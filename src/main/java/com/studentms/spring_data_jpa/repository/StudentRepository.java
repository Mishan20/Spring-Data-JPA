package com.studentms.spring_data_jpa.repository;

import com.studentms.spring_data_jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // This annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update, and delete operation on objects.
public interface StudentRepository extends JpaRepository<Student, Long>{
    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);


    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    //Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
            // This annotation is used to bind the method parameter with the named parameter.
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
            // This annotation is used to bind the method parameter with the named parameter.
    );

    @Modifying // This annotation is used to indicate that the method modifies the state of the database.
    @Transactional // This annotation is used to indicate that the method is a transactional method.
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
