package com.edu.uni.course;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("Course")
//
//public class CourseController {
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping("")
//    public List<Course> getAllCourses() {
//        return courseService.getAllCourses();
//    }
//
//    @GetMapping("id")
//    public Course getCourseById(@PathVariable int id) {
//        return courseService.getCourseById(id);
//    }
//
//    @PostMapping("")
//    public Course add(@RequestBody AddCourseDTO course) {
//        return courseService.add(course);
//    }
//
//    @PutMapping("id")
//    public Course update(@RequestBody UpdateCourseDTO course,@PathVariable int id) {
//        return courseService.update(course,id);
//    }
//    @DeleteMapping("id")
//    public void delete(@PathVariable int id) {
//        courseService.delete(id);
//    }
//}
