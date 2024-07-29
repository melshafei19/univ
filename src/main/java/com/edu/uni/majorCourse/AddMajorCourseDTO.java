package com.edu.uni.majorCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddMajorCourseDTO {
    private Integer majorId;
    private Integer courseId;
}
