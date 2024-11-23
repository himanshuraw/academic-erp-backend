package com.himanshu.academicerp.service;

import com.himanshu.academicerp.entity.Course;
import com.himanshu.academicerp.entity.Employee;
import com.himanshu.academicerp.entity.FacultyCourse;
import com.himanshu.academicerp.mapper.FacultyCourseMapper;
import com.himanshu.academicerp.repository.CourseRepository;
import com.himanshu.academicerp.repository.EmployeeRepository;
import com.himanshu.academicerp.repository.FacultyCourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyCourseService {
    EmployeeRepository employeeRepository;
    CourseRepository courseRepository;
    FacultyCourseRepository facultyCourseRepository;
    FacultyCourseMapper facultyCourseMapper;
    public String addCourses(List<Long> coursesIds, Long facultyId) {
        Employee faculty = employeeRepository.findById(facultyId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + facultyId));
        for(Long courseId : coursesIds) {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + courseId));

            FacultyCourse facultyCourse = facultyCourseMapper.toEntity(faculty, course);
            facultyCourseRepository.save(facultyCourse);
        }
        return "Courses Added";
    }
}
