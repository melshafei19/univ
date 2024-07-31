package com.edu.uni.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    public Schedule getScheduleById(int id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        return schedule.orElse(null);
    }

    public Schedule save(AddScheduleDTO addScheduleDTO){
        Schedule schedule = new Schedule();
        schedule.setCourseId(addScheduleDTO.getCourseId());
        schedule.setClassroomId(addScheduleDTO.getClassroomId());
        schedule.setDayOfWeek(addScheduleDTO.getDayOfWeek());
        schedule.setMajorId(addScheduleDTO.getMajorId());
        schedule.setStartTime(addScheduleDTO.getStartTime());
        schedule.setEndTime(addScheduleDTO.getEndTime());
        return scheduleRepository.save(schedule);
    }

    public Schedule update(UpdateScheduleDTO updateScheduleDTO,Integer id) {
        Schedule schedule = getScheduleById(id);
        schedule.setCourseId(updateScheduleDTO.getCourseId());
        schedule.setClassroomId(updateScheduleDTO.getClassroomId());
        schedule.setDayOfWeek(updateScheduleDTO.getDayOfWeek());
        schedule.setMajorId(updateScheduleDTO.getMajorId());
        schedule.setStartTime(updateScheduleDTO.getStartTime());
        schedule.setEndTime(updateScheduleDTO.getEndTime());
        return scheduleRepository.save(schedule);

    }
    public void delete(Integer id) {
        scheduleRepository.deleteById(id);
    }

}
