package com.edu.uni.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateScheduleDTO {
    private Integer courseId;
    private Integer classroomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer majorId;
    private String dayOfWeek;
}
