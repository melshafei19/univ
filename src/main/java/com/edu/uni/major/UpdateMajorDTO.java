package com.edu.uni.major;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateMajorDTO {
    private String name;
    private Integer courseId;
    private Integer doctorId;

}
