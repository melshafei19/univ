package com.edu.uni.majorCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MajorCourseDetailsDTO {
    private Integer id;
    private Integer majorId;
    private String majorName;
    private Integer courseId;
    private String courseName;
    private Integer courseCreditHour;
}
