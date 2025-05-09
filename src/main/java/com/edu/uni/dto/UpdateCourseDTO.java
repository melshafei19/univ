package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCourseDTO {
    private String name;
    private Integer creditHour;
    private Integer doctorId;
}
