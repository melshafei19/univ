package com.edu.uni.majorCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("majorCourse")
public class MajorCourseController {
    @Autowired
    MajorCourseService majorCourseService;

    @GetMapping("")
    public List<MajorCourseDetailsDTO> findAll() {
        return majorCourseService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<MajorCourseDetailsDTO> findById(@PathVariable int id) {
        Optional<MajorCourseDetailsDTO> majorCourse = majorCourseService.findById(id);
        if (majorCourse.isPresent()) {
            return ResponseEntity.ok(majorCourse.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<MajorCourseDetailsDTO> add(@RequestBody AddMajorCourseDTO addMajorCourseDTO) {
        Optional<MajorCourseDetailsDTO> createdMajorCourse = majorCourseService.save(addMajorCourseDTO);
        return createdMajorCourse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PutMapping("{id}")
    public ResponseEntity<MajorCourseDetailsDTO> update(@RequestBody UpdateMajorCourseDTO updateMajorCourseDTO, @PathVariable int id) {
        Optional<MajorCourseDetailsDTO> updatedMajorcourse = majorCourseService.update(updateMajorCourseDTO, id);
        return updatedMajorcourse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") int id) {
        majorCourseService.delete(id);
    }
}
