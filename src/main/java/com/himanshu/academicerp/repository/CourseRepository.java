package com.himanshu.academicerp.repository;

import com.himanshu.academicerp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
