package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MajorDetailsDTO {
    private Integer id;
    private String name;
    private String courseName;
    private String doctorName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
