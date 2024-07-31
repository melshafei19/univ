package com.edu.uni.majorCourse;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MajorCourseService {
    @Autowired
    MajorCourseRepository majorCourseRepository;

    public List<MajorCourseDetailsDTO> getAll() {
        return majorCourseRepository.findAllMajorCourseDetails();
    }

    public MajorCourseDetailsDTO getById(int id) {
        MajorCourseDetailsDTO majorCourse = majorCourseRepository.findMajorCourseDetailsById(id);
        return majorCourseRepository.findMajorCourseDetailsById(id);
    }

    public MajorCourse save(AddMajorCourseDTO addMajorCourseDTO) {
        MajorCourse majorCourse = new MajorCourse();
        majorCourse.setMajorId(addMajorCourseDTO.getMajorId());
        majorCourse.setCourseId(addMajorCourseDTO.getCourseId());
        return majorCourseRepository.save(majorCourse);
    }


    public MajorCourse update(UpdateMajorCourseDTO updateMajorCourseDTO, Integer id) {
        MajorCourse majorCourse = getById(id);
        if (majorCourse != null) {
            majorCourse.setMajorId(updateMajorCourseDTO.getMajorId());
            majorCourse.setCourseId(updateMajorCourseDTO.getCourseId());
            return majorCourseRepository.save(majorCourse);
        }
        throw new EntityNotFoundException("MajorCourse not found with id " + id);
    }

    private MajorCourse getById(Integer id) {
        return majorCourseRepository.findById(id).orElse(null);
    }
}
//    public void delete(int id) {
//        majorCourseRepository.deleteById(id);
//    }

