package com.edu.uni.majorCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.uni.majorCourse.MajorCourseDetailsDTO;
import com.edu.uni.majorCourse.MajorCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface MajorCourseRepository extends JpaRepository<MajorCourse, Integer> {

    @Query("SELECT new com.edu.uni.majorCourse.MajorCourseDetailsDTO(mc.id, m.id, m.name, c.id, c.name, c.creditHour) " +
            "FROM MajorCourse mc " +
            " INNER JOIN Major  m on m.id " +
            "INNER JOIN Course c on c.id")
    List<MajorCourseDetailsDTO> findAllMajorCourseDetails();

    @Query("SELECT new com.edu.uni.majorCourse.MajorCourseDetailsDTO(mc.id, m.id, m.name, c.id, c.name, c.creditHour) " +
            "FROM MajorCourse mc " +
            " INNER JOIN Major  m on m.id " +
            "INNER JOIN Course c on c.id" +
            " WHERE mc.id = :id")
    MajorCourseDetailsDTO findMajorCourseDetailsById(Integer id);
}