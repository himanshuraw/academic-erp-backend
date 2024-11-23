package com.himanshu.academicerp.service;

import com.himanshu.academicerp.dto.UserRequest;
import com.himanshu.academicerp.entity.User;
import com.himanshu.academicerp.mapper.UserMapper;
import com.himanshu.academicerp.repository.UserRepository;
import com.himanshu.academicerp.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String signup(UserRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Saved Successfully";
    }

    public String login(@Valid UserRequest request){
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        if(!passwordEncoder.matches(request.password(), user.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
