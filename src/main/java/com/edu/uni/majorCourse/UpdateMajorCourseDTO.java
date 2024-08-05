package com.edu.uni.majorCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMajorCourseDTO {
    private Integer majorId;
    private Integer courseId;
}
