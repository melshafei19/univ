package com.edu.uni.service;

import com.edu.uni.dto.AddMajorCourseDTO;
import com.edu.uni.dto.MajorCourseDetailsDTO;
import com.edu.uni.dto.UpdateMajorCourseDTO;
import com.edu.uni.model.MajorCourse;
import com.edu.uni.repositories.MajorCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MajorCourseService {
    @Autowired
    MajorCourseRepository majorCourseRepository;

    public List<MajorCourseDetailsDTO> findAll() {
        return majorCourseRepository.findAllMajorCourseDetails();
    }

    public Optional<MajorCourseDetailsDTO> findById(int majorCourseId) {
        return Optional.ofNullable(majorCourseRepository.findMajorCourseDetailsById(majorCourseId));
    }

    public Optional<MajorCourseDetailsDTO> save(AddMajorCourseDTO addMajorCourseDTO) {
        MajorCourse majorCourse = new MajorCourse();
        majorCourse.setMajorId(addMajorCourseDTO.getMajorId());
        majorCourse.setCourseId(addMajorCourseDTO.getCourseId());
        MajorCourse savedMajorCourse = majorCourseRepository.save(majorCourse);

        return Optional.ofNullable(majorCourseRepository.findMajorCourseDetailsById(savedMajorCourse.getId()));
    }

    public Optional<MajorCourseDetailsDTO> update(UpdateMajorCourseDTO updateMajorCourseDTO, int majorcourseId) {
        Optional<MajorCourse> majorCourseOptional = majorCourseRepository.findById(majorcourseId);
        if (!majorCourseOptional.isPresent()) {
            return Optional.empty();
        }

        MajorCourse majorCourse = majorCourseOptional.get();
        majorCourse.setMajorId(updateMajorCourseDTO.getMajorId());
        majorCourse.setCourseId(updateMajorCourseDTO.getCourseId());
        majorCourseRepository.save(majorCourse);

        return Optional.ofNullable(majorCourseRepository.findMajorCourseDetailsById(majorcourseId));
    }
    public void delete(int majorCourseId) {
        if (majorCourseRepository.existsById(majorCourseId)) {
            majorCourseRepository.deleteById(majorCourseId);
        }
    }}
