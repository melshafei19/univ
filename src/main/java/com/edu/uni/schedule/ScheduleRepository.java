package com.edu.uni.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    @Query(" select new com.edu.uni.schedule.ScheduleDetailsDTO(s.id, c1.name, d.name, c2.buildingName, c2.roomNumber, m.name, s.dayOfWeek, s.startTime, s.endTime, s.createdAt, s.updatedAt)" +
            " FROM Schedule s " +
            " JOIN Course c1 ON s.courseId = c1.id " +
            " JOIN Classroom c2 ON s.classroomId = c2.id " +
            " JOIN Major m ON s.majorId = m.id " +
            " JOIN Doctor d ON c1.doctorId = d.id ")
    List<ScheduleDetailsDTO> findAllScheduleDetails();

    @Query(" select new com.edu.uni.schedule.ScheduleDetailsDTO(s.id, c1.name, d.name, c2.buildingName, c2.roomNumber, m.name, s.dayOfWeek, s.startTime, s.endTime, s.createdAt, s.updatedAt)" +
            " FROM Schedule s " +
            " JOIN Course c1 ON s.courseId = c1.id " +
            " JOIN Classroom c2 ON s.classroomId = c2.id " +
            " JOIN Major m ON s.majorId = m.id " +
            " JOIN Doctor d ON c1.doctorId = d.id " +
            " Where s.id = :scheduleId")
    ScheduleDetailsDTO findScheduleDetailsById(int scheduleId);

}