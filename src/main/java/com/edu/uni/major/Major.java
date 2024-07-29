package com.edu.uni.major;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Major {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;

    @Lob
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


}
