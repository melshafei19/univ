package com.edu.uni.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddClassroomDTO {
    private String buildingName;
    private Integer roomNumber;
}
