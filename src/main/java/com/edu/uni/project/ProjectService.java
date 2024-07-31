package com.edu.uni.project;

import com.edu.uni.course.Course;
import com.edu.uni.course.CourseDetailsDTO;
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
//
//    public ProjectDTO getProjectDTOById(int id) {
//        return projectRepository.findById(id).orElse(null);
//    }
    public List<ProjectDTO> save (Project project) {
        projectRepository.save(project);
        return projectRepository.getAll();
    }
    public ProjectDTO update (Project project, int id) {
            projectRepository.save(project);
            return projectRepository.getProjectDTOById(id);
        }

//    public Project save(Project addProjectDTO) {
//        Project project = new Project();
//        project.setName(addProjectDTO.getName());
//        Course course = courseRepository.findById(addProjectDTO.getCourseId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid course ID"));
//        project.setCourse(course);
//        return projectRepository.save(project);
//    }
//
//    public Project update(Project updateProjectDTO, Integer id) {
//
//        Project project = projectRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));
//        project.setName(updateProjectDTO.getName());
//
//        Course course = courseRepository.findById(updateProjectDTO.getCourseId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid course ID"));
//        project.setCourse(course);
//        return projectRepository.save(project);
//    }

    public void delete(int id) {
        projectRepository.deleteById(id);
    }
}
