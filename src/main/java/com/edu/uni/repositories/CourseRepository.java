package com.edu.uni.repositories;

import com.edu.uni.dto.CourseDetailsDTO;
import com.edu.uni.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query(" select new com.edu.uni.dto.CourseDetailsDTO(c.id, c.name, c.creditHour, d.name, d.email, d.office, c.createdAt, c.updatedAt)" +
            " FROM Course c " +
            " JOIN Doctor d ON c.doctorId = d.id " )
    List<CourseDetailsDTO> findAllCourseDetails();

    @Query(" select new com.edu.uni.dto.CourseDetailsDTO(c.id, c.name, c.creditHour, d.name, d.email, d.office, c.createdAt, c.updatedAt)" +
            " FROM Course c " +
            " JOIN Doctor d ON c.doctorId = d.id " +
            " Where c.id = :courseId")
    CourseDetailsDTO findCourseDetailsById(int courseId);
}


