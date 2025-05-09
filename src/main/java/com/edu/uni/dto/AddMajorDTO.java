package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddMajorDTO {
    private String name;
    private Integer courseId;
    private Integer doctorId;
}
