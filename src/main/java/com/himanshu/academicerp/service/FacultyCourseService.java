package com.himanshu.academicerp.service;

import com.himanshu.academicerp.entity.Course;
import com.himanshu.academicerp.entity.Employee;
import com.himanshu.academicerp.entity.FacultyCourse;
import com.himanshu.academicerp.mapper.FacultyCourseMapper;
import com.himanshu.academicerp.repository.CourseRepository;
import com.himanshu.academicerp.repository.EmployeeRepository;
import com.himanshu.academicerp.repository.FacultyCourseRepository;
import com.himanshu.academicerp.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyCourseService {

    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;
    private final FacultyCourseRepository facultyCourseRepository;
    private final FacultyCourseMapper facultyCourseMapper;
    private final JwtUtil jwtUtil;

    public String addCourses(List<Long> coursesIds, String email, String authHeader) throws BadRequestException {
        if(!jwtUtil.validateAuthHeader(authHeader)){
            throw new BadRequestException("Invalid JWT token");
        }
        Employee faculty = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + email));
        for(Long courseId : coursesIds) {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + courseId));

            FacultyCourse facultyCourse = facultyCourseMapper.toEntity(faculty, course);
            facultyCourseRepository.save(facultyCourse);
        }
        return "Courses Added";
    }
}
