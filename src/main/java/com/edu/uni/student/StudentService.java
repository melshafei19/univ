package com.edu.uni.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public Student save(AddStudentDTO addStudentDTO) {
        Student student = new Student();
        student.setName(addStudentDTO.getName());
        student.setMajorId(addStudentDTO.getMajorId());
        student.setCourseId(addStudentDTO.getCourseId());
        student.setProjectId(addStudentDTO.getProjectId());
        student.setDateOfBirth(addStudentDTO.getDateOfBirth());
        student.setEmail(addStudentDTO.getEmail());
        student.setPhoneNumber(addStudentDTO.getPhoneNumber());
        student.setAddress(addStudentDTO.getAddress());
        return studentRepository.save(student);
    }

    public Student update(UpdateStudentDTO updateStudentDTO, Integer id) {
        Student student = getById(id);
        student.setName(updateStudentDTO.getName());
        student.setMajorId(updateStudentDTO.getMajorId());
        student.setCourseId(updateStudentDTO.getCourseId());
        student.setProjectId(updateStudentDTO.getProjectId());
        student.setDateOfBirth(updateStudentDTO.getDateOfBirth());
        student.setEmail(updateStudentDTO.getEmail());
        student.setPhoneNumber(updateStudentDTO.getPhoneNumber());
        student.setAddress(updateStudentDTO.getAddress());
        return studentRepository.save(student);
    }
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
