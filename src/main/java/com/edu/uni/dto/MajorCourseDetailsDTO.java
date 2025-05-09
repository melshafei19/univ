package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MajorCourseDetailsDTO {
    private Integer id;
    private String majorName;
    private String courseName;
    private Integer courseCreditHour;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
