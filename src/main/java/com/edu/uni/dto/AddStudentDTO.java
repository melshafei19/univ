package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentDTO {
    private String name;
    private Integer majorId;
    private Integer courseId;
    private Integer projectId;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
}
