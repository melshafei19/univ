package com.edu.uni.controller;

import com.edu.uni.dto.AddClassroomDTO;
import com.edu.uni.model.Classroom;
import com.edu.uni.service.ClassroomService;
import com.edu.uni.dto.UpdateClassroomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("classroom")

public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("getAll")
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping ("{id}")
    public Classroom getClassroomById(@PathVariable int id) {
        return classroomService.getClassroomById(id);
    }

    @PostMapping("addClassroom")
    public Classroom add(@RequestBody AddClassroomDTO classroom) {
        return classroomService.save(classroom);
    }

    @PutMapping("{id}")
    public Classroom update(@RequestBody UpdateClassroomDTO classroom, @PathVariable int id) {
        return classroomService.update(classroom,id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        classroomService.delete(id);
    }
}
