package com.edu.uni.service;

import com.edu.uni.dto.AddProjectDTO;
import com.edu.uni.dto.ProjectDetailsDTO;
import com.edu.uni.dto.UpdateProjectDTO;
import com.edu.uni.model.Project;
import com.edu.uni.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<ProjectDetailsDTO> findAll() {
        return projectRepository.findAllProjectDetails();
    }

    public Optional<ProjectDetailsDTO> findById(int projectId) {
        return Optional.ofNullable(projectRepository.findProjectDetailsById(projectId));
    }

    public Optional<ProjectDetailsDTO> save(AddProjectDTO addProjectDTO) {
        Project project = new Project();
        project.setId(addProjectDTO.getId());
        project.setName(addProjectDTO.getName());
        project.setCourseId(addProjectDTO.getCourseId());
        Project savedProject = projectRepository.save(project);

        return Optional.ofNullable(projectRepository.findProjectDetailsById(savedProject.getId()));
    }

    public Optional<ProjectDetailsDTO> update(UpdateProjectDTO updateProjectDTO, int projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (!projectOptional.isPresent()) {
            return Optional.empty();
        }

        Project project = projectOptional.get();
        project.setName(updateProjectDTO.getName());
        project.setCourseId(updateProjectDTO.getCourseId());
        projectRepository.save(project);

        return Optional.ofNullable(projectRepository.findProjectDetailsById(projectId));
    }

    public void delete(int id) {
        projectRepository.deleteById(id);
    }
}