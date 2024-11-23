package com.himanshu.academicerp.mapper;

import com.himanshu.academicerp.dto.UserRequest;
import com.himanshu.academicerp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toEntity(UserRequest loginRequest) {
        return User.builder()
                .username(loginRequest.username())
                .password(loginRequest.password())
                .build();
    }
}
