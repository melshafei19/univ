package com.edu.uni.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
