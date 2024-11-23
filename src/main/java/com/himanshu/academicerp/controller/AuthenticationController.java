package com.himanshu.academicerp.controller;

import com.himanshu.academicerp.dto.UserRequest;
import com.himanshu.academicerp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.signup(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.login(userRequest));
    }
}
