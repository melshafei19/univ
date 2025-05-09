package com.edu.uni.controller;

import com.edu.uni.dto.AddMajorDTO;
import com.edu.uni.dto.MajorDetailsDTO;
import com.edu.uni.service.MajorService;
import com.edu.uni.dto.UpdateMajorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("major")

public class MajorController {
    @Autowired
    private MajorService majorService;


    @GetMapping("getAll")
    public List<MajorDetailsDTO> findAll() {
        return majorService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<MajorDetailsDTO> findById(@PathVariable int id) {
        Optional<MajorDetailsDTO> major = majorService.findById(id);
        if (major.isPresent()) {
            return ResponseEntity.ok(major.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addMajor")
    public ResponseEntity<MajorDetailsDTO> add(@RequestBody AddMajorDTO addMajorDTO) {
        Optional<MajorDetailsDTO> createdMajor = majorService.save(addMajorDTO);
        return createdMajor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).build());
    }

    @PutMapping("{id}")
    public ResponseEntity<MajorDetailsDTO> update(@RequestBody UpdateMajorDTO updateMajorDTO, @PathVariable int id) {
        Optional<MajorDetailsDTO> updatedMajor = majorService.update(updateMajorDTO, id);
        return updatedMajor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        majorService.delete(id);
    }
}
