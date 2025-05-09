package com.edu.uni.service;

import com.edu.uni.dto.AddMajorDTO;
import com.edu.uni.dto.MajorDetailsDTO;
import com.edu.uni.dto.UpdateMajorDTO;
import com.edu.uni.model.Major;
import com.edu.uni.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service


public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public List<MajorDetailsDTO> findAll() {
        return majorRepository.findAllMajorDetails();
    }

    public Optional<MajorDetailsDTO> findById(int majorId) {
        return Optional.ofNullable(majorRepository.findMajorDetailsById(majorId));
    }

    public Optional<MajorDetailsDTO> save(AddMajorDTO addMajorDTO) {
        Major major = new Major();
        major.setName(addMajorDTO.getName());
        major.setCourseId(addMajorDTO.getCourseId());
        major.setDoctorId(addMajorDTO.getDoctorId());
        Major savedMajor = majorRepository.save(major);

        return Optional.ofNullable(majorRepository.findMajorDetailsById(savedMajor.getId()));
    }

    public Optional<MajorDetailsDTO> update(UpdateMajorDTO updateMajorDTO, int majorId) {
        Optional<Major> majorOptional = majorRepository.findById(majorId);
        if (!majorOptional.isPresent()) {
            return Optional.empty();
        }

        Major major = majorOptional.get();
        major.setName(updateMajorDTO.getName());
        major.setCourseId(updateMajorDTO.getCourseId());
        major.setDoctorId(updateMajorDTO.getDoctorId());
        majorRepository.save(major);

        return Optional.ofNullable(majorRepository.findMajorDetailsById(majorId));
    }

    public void delete(Integer id) {
        majorRepository.deleteById(id);

    }
}
