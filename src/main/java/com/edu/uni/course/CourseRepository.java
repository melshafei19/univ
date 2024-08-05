package com.edu.uni.course;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
//
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

//        @Query("select new com.edu.uni.course.CourseDetailsDTO(c.name, c.creditHour, d.name) " +
//                "from Course c" +
//                " inner join Doctor d on d.id = c.doctorId")
//        List <CourseDetailsDTO> getCourseDetails();
//
//        @Query("select new com.edu.uni.course.CourseDetailsDTO(c.name, c.creditHour, d.name) " +
//                "from Course c" +
//                " inner join Doctor d on d.id = c.doctorId" +
//                " where d.id = :doctorId ")
//        Optional<CourseDetailsDTO> getCourseDetailsDTO(int doctorId);
//
//
    }


