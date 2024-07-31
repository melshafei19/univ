package com.edu.uni.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;


    @GetMapping("")
    public List<ProjectDTO> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("{id}")
    public ProjectDTO getProjectDTO(@PathVariable int id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("")
    public List<ProjectDTO> save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping("/{id}")
    public ProjectDTO update(@RequestBody Project project, @PathVariable int id) {
        project.setId(id);
        return projectService.update(project, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        projectService.delete(id);
    }

}