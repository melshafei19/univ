package com.edu.uni.course;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDTO {

    private String name;
    private int creditHour;
    private String doctorName;

}
