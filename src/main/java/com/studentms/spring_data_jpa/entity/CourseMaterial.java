package com.studentms.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // This annotation is used to create a builder class for the entity
@ToString(exclude = "course") // This annotation is used to exclude the course field from the toString method
public class CourseMaterial {
    @Id // This annotation is used to specify the primary key of an entity
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
            // sequenceName = "course_material_sequence" is the name of the sequence in the database
    )

    @GeneratedValue(
            generator = "course_material_sequence",
            strategy = GenerationType.SEQUENCE
            // strategy = GenerationType.SEQUENCE is used to specify the primary key generation strategy
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    ) // This annotation is used to specify the relationship between two entities
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
