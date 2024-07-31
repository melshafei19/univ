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
    public List<CourseDetailsDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public CourseDetailsDTO getcourseDetailsDTO(@PathVariable int id) {
        return courseService.getcourseDetailsDTO(id);
    }

    @PostMapping("")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("{id}")
    public Course update(@RequestBody Course course, @PathVariable int id) {
        course.setId(id);
        return courseService.save(course);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }
}
