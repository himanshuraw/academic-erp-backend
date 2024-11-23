package com.himanshu.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseScheduleResponse(
        @JsonProperty("day")
        String day,

        @JsonProperty("time")
        String time,

        @JsonProperty("building")
        String building,

        @JsonProperty("room")
        String room
) {
}
