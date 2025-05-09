package com.edu.uni.repositories;

import com.edu.uni.dto.ProjectDetailsDTO;
import com.edu.uni.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(" select new com.edu.uni.dto.ProjectDetailsDTO(p.id, p.name, c.name, p.createdAt, p.updatedAt)" +
            " FROM Project p " +
            " JOIN Course c ON p.courseId = c.id " )
    List<ProjectDetailsDTO> findAllProjectDetails();

    @Query(" select new com.edu.uni.dto.ProjectDetailsDTO(p.id, p.name, c.name, p.createdAt, p.updatedAt)" +
            " FROM Project p " +
            " JOIN Course c ON p.courseId = c.id " +
            " Where p.id = :projectId" )
    ProjectDetailsDTO findProjectDetailsById(int projectId);
}
