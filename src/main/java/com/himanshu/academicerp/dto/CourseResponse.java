package com.himanshu.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.himanshu.academicerp.entity.CourseSchedule;

import java.util.List;

public record CourseResponse(
        @JsonProperty("id")
        Long id,

        @JsonProperty("code")
        String code,

        @JsonProperty("name")
        String name,

        @JsonProperty("description")
        String description,

        @JsonProperty("year")
        Integer year,

        @JsonProperty("term")
        String term,

        @JsonProperty("credits")
        Integer credits,

        @JsonProperty("capacity")
        Integer capacity,

        @JsonProperty("schedules")
        List<CourseScheduleResponse> schedule
) {
}
