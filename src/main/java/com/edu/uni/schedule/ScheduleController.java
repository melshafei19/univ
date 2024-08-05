package com.edu.uni.schedule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Schedule")

public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("")
    public List<ScheduleDetailsDTO> findAll() {
        return scheduleService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ScheduleDetailsDTO> findById(@PathVariable int id) {
        Optional<ScheduleDetailsDTO> schedule = scheduleService.findById(id);
        if (schedule.isPresent()) {
            return ResponseEntity.ok(schedule.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ScheduleDetailsDTO> add(@RequestBody AddScheduleDTO addScheduleDTO) {
        Optional<ScheduleDetailsDTO> createdSchedule = scheduleService.save(addScheduleDTO);
        return createdSchedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ScheduleDetailsDTO> update(@RequestBody UpdateScheduleDTO updateScheduleDTO, @PathVariable int id) {
        Optional<ScheduleDetailsDTO> updatedSchedule = scheduleService.update(updateScheduleDTO, id);
        return updatedSchedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        scheduleService.delete(id);
    }
}
