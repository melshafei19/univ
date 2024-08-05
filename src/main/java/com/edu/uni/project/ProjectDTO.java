package com.edu.uni.project;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private int id;
    private String name;
    private String courseName;
    private int creditHour;
    private String doctorName;

}
