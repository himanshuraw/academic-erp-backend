package com.himanshu.academicerp.mapper;

import com.himanshu.academicerp.dto.CourseResponse;
import com.himanshu.academicerp.entity.Course;
import com.himanshu.academicerp.entity.CourseSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseMapper {
    private final CourseScheduleMapper courseScheduleMapper;

    public CourseResponse toCourseResponse(Course course, List<CourseSchedule> courseSchedules) {
        return new CourseResponse(
                course.getId(),
                course.getCode(),
                course.getName(),
                course.getDescription(),
                course.getYear(),
                course.getTerm(),
                course.getCredits(),
                course.getCapacity(),
                courseScheduleMapper.toCourseSchedulesResponse(courseSchedules)
        );
    }
}
