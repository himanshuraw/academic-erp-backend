package com.himanshu.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotNull
        @NotEmpty
        @JsonProperty("username")
        String username,

        @NotNull
        @JsonProperty("password")
        String password
) {
}
