package com.edu.uni.major;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {

    @Query("SELECT new com.edu.uni.major.MajorDTO (m.id, m.name, c.name, d.name) " +
            "FROM Major m " +
            " INNER JOIN Course c ON c.id = m.courseId " +
            "INNER JOIN Doctor d ON d.id = c.doctorId ")
    List<MajorDTO> getAll();


    @Query("SELECT new com.edu.uni.major.MajorDTO (m.id, m.name, c.name, d.name) " +
            "FROM Major m " +
            " INNER JOIN Course c ON c.id = m.courseId " +
            "INNER JOIN Doctor d ON d.id = c.doctorId " +
            "WHERE m.id = :majorId")
    MajorDTO getMajorDTOById(int majorId);
}
