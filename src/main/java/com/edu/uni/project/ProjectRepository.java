package com.edu.uni.project;

//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Repository
//public interface ProjectRepository extends JpaRepository<Project, Integer> {
//
//
//}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT new com.edu.uni.project.ProjectDTO(p.id, p.name, c.name,c.creditHour, d.name) " +
            "FROM Project p " +
            "inner join Course c on c.id = p.courseId " +
            "inner join Doctor d on d.id = c.doctorId")
    List<ProjectDTO> getAll();

    @Query("SELECT new com.edu.uni.project.ProjectDTO(p.id, p.name, c.name,c.creditHour, d.name) " +
            "FROM Project p " +
            "inner join Course c on c.id = p.courseId " +
            "inner join Doctor d on d.id = c.doctorId" +
            " where p.id = :projectId")
    ProjectDTO getProjectDTOById(int projectId);

}
