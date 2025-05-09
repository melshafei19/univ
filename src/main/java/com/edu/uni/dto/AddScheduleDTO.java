package com.edu.uni.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddScheduleDTO {
    private Integer courseId;
    private Integer classroomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer majorId;
    private String dayOfWeek;
}
