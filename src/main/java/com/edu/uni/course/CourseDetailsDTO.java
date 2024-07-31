package com.edu.uni.course;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class CourseDetailsDTO {
    private String name;
    private Integer creditHour;
    private String doctorName;
}
