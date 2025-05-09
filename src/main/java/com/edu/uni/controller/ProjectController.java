package com.edu.uni.controller;

import com.edu.uni.dto.AddProjectDTO;
import com.edu.uni.dto.ProjectDetailsDTO;
import com.edu.uni.service.ProjectService;
import com.edu.uni.dto.UpdateProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("getAll")
    public List<ProjectDetailsDTO> findAll() {
        return projectService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectDetailsDTO> findById(@PathVariable int id) {
        Optional<ProjectDetailsDTO> project = projectService.findById(id);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addProject")
    public ResponseEntity<ProjectDetailsDTO> add(@RequestBody AddProjectDTO addProjectDTO) {
        Optional<ProjectDetailsDTO> createdProject = projectService.save(addProjectDTO);
        return createdProject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjectDetailsDTO> update(@RequestBody UpdateProjectDTO updateProjectDTO, @PathVariable int id) {
        Optional<ProjectDetailsDTO> updatedProject = projectService.update(updateProjectDTO, id);
        return updatedProject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") int id){
        projectService.delete(id);
    }
}
