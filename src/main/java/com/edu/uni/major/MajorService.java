package com.edu.uni.major;


import com.edu.uni.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service


public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private CourseRepository courseRepository;



    public List<MajorDTO> findAll() {
        return majorRepository.getAll();
    }
    public MajorDTO getMajorById(int id) {
        return majorRepository.getMajorDTOById(id);

    }

    public List<MajorDTO> save (Major major) {
        majorRepository.save(major);
        return majorRepository.getAll();
    }
    public MajorDTO update(Major major, int id) {
        majorRepository.save(major);
        return majorRepository.getMajorDTOById(id);
    }

//    public Major save(Major major) {
//        Major major = new Major();
//        major.setName(addMajorDTO.getName());
//        major.setCourseId(addMajorDTO.getCourseId());
//        major.setDoctorId(addMajorDTO.getDoctorId());
//        return majorRepository.save(major);
//    }
//
//    public Major update(UpdateMajorDTO updateMajorDTO,Integer id) {
//        Major major = getMajorDetailsDTO(id);
//        major.setName(updateMajorDTO.getName());
//        major.setCourseId(updateMajorDTO.getCourseId());
//        major.setDoctorId(updateMajorDTO.getDoctorId());
//        return majorRepository.save(major);
    public void delete(int id) {
        majorRepository.deleteById(id);
    }
}
