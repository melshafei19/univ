package com.edu.uni.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateClassroomDTO {

    private String buildingName;
    private Integer roomNumber;
}
