package com.edu.uni.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("Classroom")

public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("")
    public List<Classroom> getAllClassrooms() {

        return classroomService.getAllClassrooms();
    }

    @GetMapping ("id")
    public Classroom getClassroomById(@PathVariable int id) {
        return classroomService.getClassroomById(id);

    }
    @PostMapping("")
    public Classroom add(@RequestBody AddClassroomDTO classroom) {

        return classroomService.save(classroom);
    }
    @PutMapping("id")
    public Classroom update(@RequestBody UpdateClassroomDTO classroom,@PathVariable int id) {
        return classroomService.update(classroom,id);

    }
    @DeleteMapping("id")
    public void delete(@PathVariable("id") int id) {

        classroomService.delete(id);
    }

}
