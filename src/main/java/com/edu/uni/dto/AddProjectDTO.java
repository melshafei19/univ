package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProjectDTO {
    private Integer id;
    private String name;
    private Integer courseId;
}
