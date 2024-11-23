package com.himanshu.academicerp.repository;

import com.himanshu.academicerp.entity.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {
    List<CourseSchedule> findByCourseId(Long courseId);
}
