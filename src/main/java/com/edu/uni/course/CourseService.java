package com.edu.uni.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service


public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> findAll() {
        return courseRepository.getAll();
    }

    public CourseDTO getCourseById(int id) {
        return courseRepository.getCourseDTOById(id);
    }


    public List<CourseDTO> save(Course course) {
        courseRepository.save(course);
        return courseRepository.getAll();
    }

    public CourseDTO update(Course course,int id) {
        courseRepository.save(course);
        return courseRepository.getCourseDTOById(id);

    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }

}
