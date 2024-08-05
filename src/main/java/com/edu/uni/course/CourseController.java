package com.edu.uni.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("Course")

public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<CourseDTO> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseDTO(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("")
    public List<CourseDTO> save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@RequestBody Course course, @PathVariable int id) {
        course.setId(id);
        return courseService.update(course, id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }
}
