package com.edu.uni.project;

import com.edu.uni.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "course_id")
    private Integer courseId;
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Project(String name, Integer courseId) {
        this.name = name;
        this.courseId = courseId;
    }
}