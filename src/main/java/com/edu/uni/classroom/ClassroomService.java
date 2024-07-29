package com.edu.uni.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
    public Classroom getClassroomById(int id) {
        Optional<Classroom> classroom= classroomRepository.findById(id);
        return classroom.orElse(null);
    }
    public Classroom save(AddClassroomDTO addClassroomDTO){
        Classroom classroom = new Classroom();
        classroom.setBuildingName(addClassroomDTO.getBuildingName());
        classroom.setRoomNumber(addClassroomDTO.getRoomNumber());
        return classroomRepository.save(classroom);

    }

    public Classroom update(UpdateClassroomDTO updateClassroomDTO,Integer id) {
        Classroom classroom = getClassroomById(id);
        classroom.setBuildingName(updateClassroomDTO.getBuildingName());
        classroom.setRoomNumber(updateClassroomDTO.getRoomNumber());
        return classroomRepository.save(classroom);

    }
    public void delete(int id) {
        classroomRepository.deleteById(id);
    }
}

