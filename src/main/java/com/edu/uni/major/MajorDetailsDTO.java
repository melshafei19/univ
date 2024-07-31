package com.edu.uni.major;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MajorDetailsDTO {
    private String name;
    private Integer courseId;
    private String courseName;
    private Integer doctorId;
    private String doctorName;

}
