package com.himanshu.academicerp.service;

import com.himanshu.academicerp.dto.CourseResponse;
import com.himanshu.academicerp.entity.Course;
import com.himanshu.academicerp.entity.CourseSchedule;
import com.himanshu.academicerp.mapper.CourseMapper;
import com.himanshu.academicerp.repository.CourseRepository;
import com.himanshu.academicerp.repository.CourseScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseScheduleRepository courseScheduleRepository;

    public List<CourseResponse> retrieveAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            List<CourseSchedule> courseSchedules = courseScheduleRepository.findByCourseId(course.getId());
            CourseResponse courseResponse = courseMapper.toCourseResponse(course, courseSchedules);
            courseResponses.add(courseResponse);
        }

        return courseResponses;
    }
}
