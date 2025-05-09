package com.edu.uni.repositories;

import com.edu.uni.dto.MajorCourseDetailsDTO;
import com.edu.uni.model.MajorCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MajorCourseRepository extends JpaRepository<MajorCourse, Integer> {
    @Query(" select new com.edu.uni.dto.MajorCourseDetailsDTO(mc.id, m.name, c.name, c.creditHour, mc.createdAt, mc.updatedAt)" +
            " FROM MajorCourse mc " +
            " JOIN Major m ON mc.majorId = m.id " +
            " JOIN Course c ON mc.courseId = c.id ")
    List<MajorCourseDetailsDTO> findAllMajorCourseDetails();

    @Query(" select new com.edu.uni.dto.MajorCourseDetailsDTO(mc.id, m.name, c.name, c.creditHour, mc.createdAt, mc.updatedAt)" +
            " FROM MajorCourse mc " +
            " JOIN Major m ON mc.majorId = m.id " +
            " JOIN Course c ON mc.courseId = c.id " +
            " Where mc.id = :majorCourseId")
    MajorCourseDetailsDTO findMajorCourseDetailsById(int majorCourseId);
}