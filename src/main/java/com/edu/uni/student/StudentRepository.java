package com.edu.uni.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(" select new com.edu.uni.student.StudentDetailsDTO(s.id, s.name, m.name, d1.name, c.name, c.creditHour, d2.name, p.name, s.dateOfBirth, s.email, s.phoneNumber, s.address, s.createdAt, s.updatedAt)" +
            " FROM Student s " +
            " JOIN Major m ON s.majorId = m.id " +
            " JOIN Course c ON s.courseId = c.id " +
            " JOIN Project p ON s.projectId = p.id" +
            " JOIN Doctor d1 ON m.doctorId = d1.id " +
            " JOIN Doctor d2 ON c.doctorId = d2.id " )
    List<StudentDetailsDTO> findAllStudentDetails();


    @Query(" select new com.edu.uni.student.StudentDetailsDTO(s.id, s.name, m.name, d1.name, c.name, c.creditHour, d2.name, p.name, s.dateOfBirth, s.email, s.phoneNumber, s.address, s.createdAt, s.updatedAt)" +
            " FROM Student s " +
            " JOIN Major m ON s.majorId = m.id " +
            " JOIN Course c ON s.courseId = c.id " +
            " JOIN Project p ON s.projectId = p.id" +
            " JOIN Doctor d1 ON m.doctorId = d1.id " +
            " JOIN Doctor d2 ON c.doctorId = d2.id " +
            " Where s.id = :studentId")
    StudentDetailsDTO findStudentDetailsById(int studentId);
}

