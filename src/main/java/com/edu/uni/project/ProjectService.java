package com.edu.uni.project;

import com.edu.uni.course.Course;

import com.edu.uni.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<ProjectDTO> findAll(){
        return projectRepository.getAll();
    }
    public ProjectDTO getProjectById(int id) {
        return projectRepository.getProjectDTOById(id);
    }

    public List<ProjectDTO> save (Project project) {
        projectRepository.save(project);
        return projectRepository.getAll();
    }
    public ProjectDTO update (Project project, int id) {
            projectRepository.save(project);
            return projectRepository.getProjectDTOById(id);
        }

    public void delete(int id) {
        projectRepository.deleteById(id);
    }
}
