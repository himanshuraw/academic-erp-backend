package com.himanshu.academicerp.controller;

import com.himanshu.academicerp.dto.EmployeeRequest;
import com.himanshu.academicerp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestHeader("Authorization") String authHeader,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("photograph") MultipartFile photograph,
            @RequestParam("department") String department) throws IOException {

        // Create the EmployeeRequest manually from the form data
        EmployeeRequest request = new EmployeeRequest(firstName, lastName, email, photograph, department);

        return ResponseEntity.ok(employeeService.registerEmployee(request, authHeader));
    }
}
