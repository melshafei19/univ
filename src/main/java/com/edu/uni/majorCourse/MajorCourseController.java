package com.edu.uni.majorCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("majorCourse")
public class MajorCourseController {
    @Autowired
    MajorCourseService majorCourseService;

    @GetMapping("")
    public List<MajorCourseDetailsDTO> getAllMajorCourseDetails() {
        return majorCourseService.getAll();
    }

    @GetMapping("/{id}")
    public MajorCourseDetailsDTO getMajorCourseById(@PathVariable int id) {
        return majorCourseService.getById(id);
    }

    @PostMapping("")
    public MajorCourse add(@RequestBody AddMajorCourseDTO majorCourse) {
        return majorCourseService.save(majorCourse);
    }


    @PutMapping("/{id}")
    public MajorCourse update(@RequestBody UpdateMajorCourseDTO updateMajorCourseDTO, @PathVariable int id) {
        return majorCourseService.update(updateMajorCourseDTO, id);
    }
//
//    @DeleteMapping("id")
//    public void delete(@PathVariable ("id") int id) {
//        majorCourseService.delete(id);
//    }
}
