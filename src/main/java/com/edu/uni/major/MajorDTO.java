package com.edu.uni.major;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTO {
    private int id;
    private String name;
    private String courseName;
    private String doctorName;
}
