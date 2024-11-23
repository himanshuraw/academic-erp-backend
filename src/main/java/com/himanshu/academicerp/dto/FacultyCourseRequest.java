package com.himanshu.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

public record FacultyCourseRequest(
        @NonNull
        @JsonProperty("faculty_id")
        Long employee_id,

        @NonNull
        @JsonProperty("course_id")
        Long course_id
) {
}
