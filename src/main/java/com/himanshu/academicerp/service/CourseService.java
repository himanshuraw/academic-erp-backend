package com.himanshu.academicerp.service;

import com.himanshu.academicerp.dto.CourseResponse;
import com.himanshu.academicerp.entity.Course;
import com.himanshu.academicerp.entity.CourseSchedule;
import com.himanshu.academicerp.mapper.CourseMapper;
import com.himanshu.academicerp.repository.CourseRepository;
import com.himanshu.academicerp.repository.CourseScheduleRepository;
import com.himanshu.academicerp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseScheduleRepository courseScheduleRepository;
    private final JwtUtil jwtUtil;
    public List<CourseResponse> retrieveAllCourses(String authHeader) throws BadRequestException {
        if(!jwtUtil.validateAuthHeader(authHeader)){
            throw new BadRequestException("Invalid JWT token");
        }
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
