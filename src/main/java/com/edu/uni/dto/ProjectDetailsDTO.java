package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjectDetailsDTO {
        private Integer id;
        private String name;
        private String courseName;
        private Timestamp createdAt;
        private Timestamp updatedAt;
}
