package com.himanshu.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record EmployeeRequest(
        @NotNull(message = "First name cannot be null")
        @NotEmpty(message = "First name cannot be empty")
        @JsonProperty("firstName")
        String firstName,

        @NotNull(message = "Last name cannot be null")
        @NotEmpty(message = "Last name cannot be empty")
        @JsonProperty("lastName")
        String lastName,


        @NotNull(message = "Email cannot be null")
        @NotEmpty(message = "Email cannot be empty")
        @JsonProperty("email")
        String email,

        @NotNull(message = "Image is required")
        @JsonProperty("photograph")
        MultipartFile photograph,

        @NotNull(message = "Department can not be null")
        @NotEmpty(message = "Department can not be empty")
        @JsonProperty("department")
        String department
) {
}
