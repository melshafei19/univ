package com.edu.uni.major;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {

    @Query(value = "SELECT m.id as majorId, m.name as majorName, c.id as courseId, c.name as courseName, d.id as doctorId, d.name as doctorName " +
            "FROM Major m " +
            "JOIN Course c ON m.id = c.major_id " +
            "JOIN Doctor d ON c.doctor_id = d.id " +
            "WHERE m.id = :majorId", nativeQuery = true)
    List<Major> getMajorDetailsDTO(@PathVariable("majorId") Integer majorId);
}
