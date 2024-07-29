package com.edu.uni.schedule;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddScheduleDTO {
    private Integer courseId;
    private Integer classroom_id;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer majorId;
    private String dayOfWeek;

}
