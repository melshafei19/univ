package com.edu.uni.major;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service


public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public List<Major> getAll() {
        return majorRepository.findAll();
    }
    public Major getById(int id) {
        Optional<Major> major = majorRepository.findById(id);
        return major.orElse(null);
    }
    public Major save(AddMajorDTO addMajorDTO) {
        Major major = new Major();
        major.setName(addMajorDTO.getName());
        major.setCourseId(addMajorDTO.getCourseId());
        major.setDoctorId(addMajorDTO.getDoctorId());
        return majorRepository.save(major);
    }

    public Major update(UpdateMajorDTO updateMajorDTO,Integer id) {
        Major major = getById(id);
        major.setName(updateMajorDTO.getName());
        major.setCourseId(updateMajorDTO.getCourseId());
        major.setDoctorId(updateMajorDTO.getDoctorId());
        return majorRepository.save(major);
    }
    public void delete(Integer id) {
        majorRepository.deleteById(id);

    }
}
