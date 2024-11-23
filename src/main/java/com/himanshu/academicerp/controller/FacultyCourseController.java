package com.himanshu.academicerp.controller;

import com.himanshu.academicerp.dto.FacultyCourseRequest;
import com.himanshu.academicerp.service.FacultyCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addCourses")
public class FacultyCourseController {
    private final FacultyCourseService facultyCourseService;
    @PostMapping("/{faculty_id}")
    public ResponseEntity<String> addCourses(@RequestBody List<Long> courses_ids, @PathVariable Long faculty_id) {
        return ResponseEntity.ok(facultyCourseService.addCourses(courses_ids, faculty_id));
    }
}
