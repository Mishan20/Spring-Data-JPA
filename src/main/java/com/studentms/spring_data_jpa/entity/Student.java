package com.studentms.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // This annotation is used to specify that the class is an entity and is mapped to a database table.
@Data // This annotation is used to generate getters and setters for the fields.
@AllArgsConstructor // This annotation is used to generate a constructor with all the fields.
@NoArgsConstructor // This annotation is used to generate a default constructor.
@Builder // This annotation is used to create an instance of the class with the builder pattern.
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id // This annotation is used to specify the primary key of an entity.
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded // This annotation is used to specify that the entity has an embedded object.
    private Guardian guardian;
}
