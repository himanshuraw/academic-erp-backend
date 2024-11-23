package com.himanshu.academicerp.mapper;

import com.himanshu.academicerp.dto.CourseScheduleResponse;
import com.himanshu.academicerp.entity.CourseSchedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseScheduleMapper {
//    public List<CourseScheduleResponse> toCourseSchedulesResponse(List<CourseSchedule> courseScheduleList) {
//        List<CourseScheduleResponse> courseScheduleResponses = new ArrayList<>();
//        for(CourseSchedule courseSchedule : courseScheduleList) {
//            CourseScheduleResponse courseScheduleResponse = toCourseScheduleResponse(courseSchedule);
//            courseScheduleResponses.add(courseScheduleResponse);
//        }
//        return courseScheduleResponses;
//    }

    public List<CourseScheduleResponse> toCourseSchedulesResponse(List<CourseSchedule> courseScheduleList) {
        // Using Stream API for cleaner and more concise mapping
        return courseScheduleList.stream()
                .map(this::toCourseScheduleResponse)
                .toList();
    }

    public CourseScheduleResponse toCourseScheduleResponse(CourseSchedule courseSchedule) {
        return new CourseScheduleResponse(
                courseSchedule.getDay(),
                courseSchedule.getTime(),
                courseSchedule.getBuilding(),
                courseSchedule.getRoom()
        );
    }
}
