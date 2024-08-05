package com.edu.uni.majorCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddMajorCourseDTO {
    private Integer majorId;
    private Integer courseId;
}
