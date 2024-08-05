package com.edu.uni.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("Major")

public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping("")
    public List<MajorDTO> getAllMajors() {
        return majorService.findAll();
    }

    @GetMapping ("{id}")
    public MajorDTO getProjectDTO(@PathVariable int id) {
        return majorService.getMajorById(id);

    }
    @PostMapping("")
    public List<MajorDTO> save(@RequestBody Major major) {
        return majorService.save(major);
    }

    @PutMapping("{id}")
    public MajorDTO update(@RequestBody Major major, @PathVariable int id) {
        major.setId(id);
        return majorService.update(major, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        majorService.delete(id);
    }


}
