package com.edu.uni.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentDetailsDTO> findAll() {
        return studentRepository.findAllStudentDetails();
    }

    public Optional<StudentDetailsDTO> findById(int studentId) {
        return Optional.ofNullable(studentRepository.findStudentDetailsById(studentId));
    }

    public Optional<StudentDetailsDTO> save(AddStudentDTO addStudentDTO) {
        Student student = new Student();
        student.setName(addStudentDTO.getName());
        student.setMajorId(addStudentDTO.getMajorId());
        student.setCourseId(addStudentDTO.getCourseId());
        student.setProjectId(addStudentDTO.getProjectId());
        student.setDateOfBirth(addStudentDTO.getDateOfBirth());
        student.setEmail(addStudentDTO.getEmail());
        student.setPhoneNumber(addStudentDTO.getPhoneNumber());
        student.setAddress(addStudentDTO.getAddress());
        Student savedStudent = studentRepository.save(student);

        return Optional.ofNullable(studentRepository.findStudentDetailsById(savedStudent.getId()));
    }

    public Optional<StudentDetailsDTO> update(UpdateStudentDTO updateStudentDTO, int studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            return Optional.empty();
        }

        Student student = studentOptional.get();
        student.setName(updateStudentDTO.getName());
        student.setMajorId(updateStudentDTO.getMajorId());
        student.setCourseId(updateStudentDTO.getCourseId());
        student.setProjectId(updateStudentDTO.getProjectId());
        student.setDateOfBirth(updateStudentDTO.getDateOfBirth());
        student.setEmail(updateStudentDTO.getEmail());
        student.setPhoneNumber(updateStudentDTO.getPhoneNumber());
        student.setAddress(updateStudentDTO.getAddress());
        studentRepository.save(student);

        return Optional.ofNullable(studentRepository.findStudentDetailsById(studentId));
    }

    public void delete(int studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        }
    }
}



