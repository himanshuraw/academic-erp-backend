package com.himanshu.academicerp.controller;

import com.himanshu.academicerp.dto.CourseResponse;
import com.himanshu.academicerp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> retrieveAllCourses() {
        return ResponseEntity.ok(courseService.retrieveAllCourses());
    }
}
