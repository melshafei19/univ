package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class AddDoctorDTO {
    private String name;
    private String email;
    private String office;
}
