package com.edu.uni.schedule;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateScheduleDTO {
    private Integer courseId;
    private Integer classroom_id;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer majorId;
    private String dayOfWeek;

}
