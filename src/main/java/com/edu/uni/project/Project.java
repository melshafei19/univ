package com.edu.uni.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}