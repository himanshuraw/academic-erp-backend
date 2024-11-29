package com.himanshu.academicerp.controller;

import com.himanshu.academicerp.dto.FacultyCourseRequest;
import com.himanshu.academicerp.service.FacultyCourseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addCourses")
public class FacultyCourseController {
    private final FacultyCourseService facultyCourseService;
    @PostMapping("/{email}")
    public ResponseEntity<String> addCourses(@RequestBody List<Long> courses_ids, @PathVariable String email, @RequestHeader("Authorization")String authHeader) throws BadRequestException {
        return ResponseEntity.ok(facultyCourseService.addCourses(courses_ids, email, authHeader));
    }
}
