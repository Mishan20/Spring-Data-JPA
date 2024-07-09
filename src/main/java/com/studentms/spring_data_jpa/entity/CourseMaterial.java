package com.studentms.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // This annotation is used to create a builder class for the entity
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
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
