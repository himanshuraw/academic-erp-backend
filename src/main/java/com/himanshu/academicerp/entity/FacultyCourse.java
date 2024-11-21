package com.himanshu.academicerp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class FacultyCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Employee faculty;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
