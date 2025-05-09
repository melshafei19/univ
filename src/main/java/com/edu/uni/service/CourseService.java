package com.edu.uni.service;

import com.edu.uni.dto.AddCourseDTO;
import com.edu.uni.dto.CourseDetailsDTO;
import com.edu.uni.dto.UpdateCourseDTO;
import com.edu.uni.model.Course;
import com.edu.uni.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service


public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDetailsDTO> findAll() {
        return courseRepository.findAllCourseDetails();
    }

    public Optional<CourseDetailsDTO> findById(int courseId) {
        return Optional.ofNullable(courseRepository.findCourseDetailsById(courseId));
    }

    public Optional<CourseDetailsDTO> save(AddCourseDTO addCourseDTO) {
        Course course = new Course();
        course.setName(addCourseDTO.getName());
        course.setCreditHour(addCourseDTO.getCreditHour());
        course.setDoctorId(addCourseDTO.getDoctorId());
        Course savedCourse = courseRepository.save(course);

        return Optional.ofNullable(courseRepository.findCourseDetailsById(savedCourse.getId()));
    }

    public Optional<CourseDetailsDTO> update(UpdateCourseDTO updateCourseDTO, int courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (!courseOptional.isPresent()) {
            return Optional.empty();
        }

        Course course = courseOptional.get();
        course.setName(updateCourseDTO.getName());
        course.setCreditHour(updateCourseDTO.getCreditHour());
        course.setDoctorId(updateCourseDTO.getDoctorId());
        courseRepository.save(course);

        return Optional.ofNullable(courseRepository.findCourseDetailsById(courseId));
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }

}
