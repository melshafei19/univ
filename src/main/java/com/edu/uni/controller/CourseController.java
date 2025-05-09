package com.edu.uni.controller;

import com.edu.uni.dto.AddCourseDTO;
import com.edu.uni.dto.CourseDetailsDTO;
import com.edu.uni.service.CourseService;
import com.edu.uni.dto.UpdateCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("course")

public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("getAll")
    public List<CourseDetailsDTO> findAll() {
        return courseService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDetailsDTO> findById(@PathVariable int id) {
        Optional<CourseDetailsDTO> course = courseService.findById(id);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addCourse")
    public ResponseEntity<CourseDetailsDTO> add(@RequestBody AddCourseDTO addCourseDTO) {
        Optional<CourseDetailsDTO> createdCourse = courseService.save(addCourseDTO);
        return createdCourse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseDetailsDTO> update(@RequestBody UpdateCourseDTO updateCourseDTO, @PathVariable int id) {
        Optional<CourseDetailsDTO> updatedCourse = courseService.update(updateCourseDTO, id);
        return updatedCourse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }
}
