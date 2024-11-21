package com.himanshu.academicerp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    private String day;
    private String time;
    private String building;
    private String room;
}
