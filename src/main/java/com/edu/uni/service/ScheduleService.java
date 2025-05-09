package com.edu.uni.service;

import com.edu.uni.dto.AddScheduleDTO;
import com.edu.uni.dto.ScheduleDetailsDTO;
import com.edu.uni.dto.UpdateScheduleDTO;
import com.edu.uni.model.Schedule;
import com.edu.uni.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<ScheduleDetailsDTO> findAll() {
        return scheduleRepository.findAllScheduleDetails();
    }

    public Optional<ScheduleDetailsDTO> findById(int scheduleId) {
        return Optional.ofNullable(scheduleRepository.findScheduleDetailsById(scheduleId));
    }

public Optional<ScheduleDetailsDTO> save(AddScheduleDTO addScheduleDTO) {
    Schedule schedule = new Schedule();
    schedule.setCourseId(addScheduleDTO.getCourseId());
    schedule.setClassroomId(addScheduleDTO.getClassroomId());
    schedule.setStartTime(addScheduleDTO.getStartTime());
    schedule.setEndTime(addScheduleDTO.getEndTime());
    schedule.setMajorId(addScheduleDTO.getMajorId());
    schedule.setDayOfWeek(addScheduleDTO.getDayOfWeek());
    Schedule savedSchedule = scheduleRepository.save(schedule);

    return Optional.ofNullable(scheduleRepository.findScheduleDetailsById(savedSchedule.getId()));
}

    public Optional<ScheduleDetailsDTO> update(UpdateScheduleDTO updateScheduleDTO, int scheduleId) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);
        if (!scheduleOptional.isPresent()) {
            return Optional.empty();
        }

        Schedule schedule = scheduleOptional.get();
        schedule.setCourseId(updateScheduleDTO.getCourseId());
        schedule.setClassroomId(updateScheduleDTO.getClassroomId());
        schedule.setStartTime(updateScheduleDTO.getStartTime());
        schedule.setEndTime(updateScheduleDTO.getEndTime());
        schedule.setMajorId(updateScheduleDTO.getMajorId());
        schedule.setDayOfWeek(updateScheduleDTO.getDayOfWeek());
        scheduleRepository.save(schedule);

        return Optional.ofNullable(scheduleRepository.findScheduleDetailsById(scheduleId));
    }
    public void delete(int scheduleId) {
        if (scheduleRepository.existsById(scheduleId)) {
            scheduleRepository.deleteById(scheduleId);
        }
    }

}
