package com.edu.uni.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("Schedule")

public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("{id}")
    public Schedule getScheduleById(@PathVariable int id) {
        return scheduleService.getScheduleById(id);
    }
    @PostMapping("")
    public Schedule add(@RequestBody AddScheduleDTO schedule) {
        return scheduleService.save(schedule);
    }
    @PutMapping("{id}")
    public Schedule update(@RequestBody UpdateScheduleDTO schedule, @PathVariable int id) {
        return scheduleService.update(schedule, id);
    }
    @DeleteMapping("id")
    public void delete(@PathVariable int id) {
        scheduleService.delete(id);
    }

}
