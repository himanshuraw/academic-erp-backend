package com.himanshu.academicerp.mapper;

import com.himanshu.academicerp.entity.Course;
import com.himanshu.academicerp.entity.Employee;
import com.himanshu.academicerp.entity.FacultyCourse;

public class FacultyCourseMapper {
    public FacultyCourse toEntity(Employee faculty, Course course) {
        return FacultyCourse.builder()
                .faculty(faculty)
                .course(course)
                .build();
    }
}
