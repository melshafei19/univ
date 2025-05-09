package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddCourseDTO {
    private String name;
    private Integer creditHour;
    private Integer doctorId;
}
