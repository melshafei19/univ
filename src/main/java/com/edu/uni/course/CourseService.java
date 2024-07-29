package com.edu.uni.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service


public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(int id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }
    public Course add(AddCourseDTO addCourseDTO) {
        Course course = new Course();
        course.setName(addCourseDTO.getName());
        course.setCreditHour(addCourseDTO.getCreditHour());
        course.setDoctorId(addCourseDTO.getDoctorId());
        return courseRepository.save(course);
    }
    public Course update(UpdateCourseDTO updateCourseDTO,Integer id) {
        Course course = getCourseById(id);
        course.setName(updateCourseDTO.getName());
        course.setCreditHour(updateCourseDTO.getCreditHour());
        course.setDoctorId(updateCourseDTO.getDoctorId());
        return courseRepository.save(course);
    }
    public void delete(int id) {
        courseRepository.deleteById(id);
    }

}
