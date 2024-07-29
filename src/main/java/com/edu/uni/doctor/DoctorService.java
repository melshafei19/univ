package com.edu.uni.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getById(int id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    public Doctor save(AddDoctorDTO addDoctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(addDoctorDTO.getName());
        doctor.setEmail(addDoctorDTO.getEmail());
        doctor.setOffice(addDoctorDTO.getOffice());
        return doctorRepository.save(doctor);
    }

    public Doctor update(UpdateDoctorDTO updateDoctorDTO, Integer id) {
        Doctor doctor = getById(id);
        doctor.setName(updateDoctorDTO.getName());
        doctor.setEmail(updateDoctorDTO.getEmail());
        doctor.setOffice(updateDoctorDTO.getOffice());
        return doctorRepository.save(doctor);
    }

    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
}
