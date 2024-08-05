package com.edu.uni.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsDTO {
    private Integer id;
    private String name;
    private String majorName;
    private String majorDoctorName;
    private String courseName;
    private Integer courseCreditHour;
    private String courseDoctorName;
    private String projectName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}


