package com.edu.uni.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class CourseDetailsDTO {
    private Integer id;
    private String name;
    private Integer creditHour;
    private String doctorName;
    private String doctorEmail;
    private String doctorOffice;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
