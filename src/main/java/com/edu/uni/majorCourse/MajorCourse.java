package com.edu.uni.majorCourse;

import com.edu.uni.course.Course;
import com.edu.uni.major.Major;
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
public class MajorCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "major_id")
//    private Major major;

//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;

    @Column(name = "major_id", nullable = false)
    private Integer majorId;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


}
