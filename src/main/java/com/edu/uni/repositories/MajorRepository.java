package com.edu.uni.repositories;

import com.edu.uni.dto.MajorDetailsDTO;
import com.edu.uni.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {
    @Query(" select new com.edu.uni.dto.MajorDetailsDTO(m.id, m.name, c.name, d.name, m.createdAt, m.updatedAt)" +
            " FROM Major m " +
            " JOIN Course c ON m.courseId = c.id " +
            " JOIN Doctor d ON m.doctorId = d.id " )
    List<MajorDetailsDTO> findAllMajorDetails();


    @Query(" select new com.edu.uni.dto.MajorDetailsDTO(m.id, m.name, c.name, d.name, m.createdAt, m.updatedAt)" +
            " FROM Major m " +
            " JOIN Course c ON m.courseId = c.id " +
            " JOIN Doctor d ON m.doctorId = d.id " +
           " Where m.id = :majorId")
    MajorDetailsDTO findMajorDetailsById(int majorId);
}
