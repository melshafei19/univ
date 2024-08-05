package com.edu.uni.classroom;

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
