package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDetailsDTO {
    private Integer id;
    private String courseName;
    private String courseDoctorName;
    private String classroomBuildingName;
    private Integer classroomRoomNumber;
    private String majorName;
    private String dayOfWeek;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
