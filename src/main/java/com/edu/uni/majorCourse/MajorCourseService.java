package com.edu.uni.majorCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MajorCourseService {
    @Autowired
    MajorCourseRepository majorCourseRepository;

    public List<MajorCourse> getAll() {
        return majorCourseRepository.findAll();
    }

    public MajorCourse getById(int id) {
        Optional<MajorCourse> majorCourse = majorCourseRepository.findById(id);
        return majorCourse.orElse(null);
    }

    public MajorCourse save(AddMajorCourseDTO addMajorCourseDTO) {
        MajorCourse majorCourse = new MajorCourse();
        majorCourse.setMajorId(addMajorCourseDTO.getMajorId());
        majorCourse.setCourseId(addMajorCourseDTO.getCourseId());
        return majorCourseRepository.save(majorCourse);
    }


    public MajorCourse update(UpdateMajorCourseDTO updateMajorCourseDTO, Integer id) {
        MajorCourse majorCourse = getById(id);
        majorCourse.setMajorId(updateMajorCourseDTO.getMajorId());
        majorCourse.setCourseId(updateMajorCourseDTO.getCourseId());
        return majorCourseRepository.save(majorCourse);
    }

    public void delete(int id) {
        majorCourseRepository.deleteById(id);
    }
}
