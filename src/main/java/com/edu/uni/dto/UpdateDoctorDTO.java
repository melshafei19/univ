package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateDoctorDTO {
        private String name;
        private String email;
        private String office;
}
