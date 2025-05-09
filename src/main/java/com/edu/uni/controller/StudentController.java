package com.edu.uni.controller;

import com.edu.uni.dto.AddStudentDTO;
import com.edu.uni.dto.StudentDetailsDTO;
import com.edu.uni.service.StudentService;
import com.edu.uni.dto.UpdateStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("getAll")
    public List<StudentDetailsDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDetailsDTO> findById(@PathVariable int id) {
        Optional<StudentDetailsDTO> student = studentService.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
         } else {
            return ResponseEntity.notFound().build();
         }
    }

    @PostMapping("addStudent")
    public ResponseEntity<StudentDetailsDTO> add(@RequestBody AddStudentDTO addStudentDTO) {
        Optional<StudentDetailsDTO> createdStudent = studentService.save(addStudentDTO);
        return createdStudent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDetailsDTO> update(@RequestBody UpdateStudentDTO updateStudentDTO, @PathVariable int id) {
        Optional<StudentDetailsDTO> updatedStudent = studentService.update(updateStudentDTO, id);
        return updatedStudent.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") int id) {
        studentService.delete(id);
    }
    }