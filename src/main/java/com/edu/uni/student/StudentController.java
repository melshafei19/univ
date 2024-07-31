package com.edu.uni.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping("")
public Student add(@RequestBody AddStudentDTO student) {
        return studentService.save(student);
    }

    @PutMapping("{id}")
    public Student update(@RequestBody UpdateStudentDTO student, @PathVariable int id) {
        return studentService.update(student,id);
    }

    @DeleteMapping("id")
    public void delete(@PathVariable ("id") int id) {
        studentService.delete(id);
    }
}
