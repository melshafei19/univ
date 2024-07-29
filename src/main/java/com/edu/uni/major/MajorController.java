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
    public List<Major> getAllMajors() {
        return majorService.getAll();
    }

    @GetMapping ("id")
    public Major getById(@PathVariable int id) {
        return majorService.getById(id);

    }
    @PostMapping("")
    public Major add(@RequestBody AddMajorDTO major) {
        return majorService.save(major);
    }

    @PutMapping("id")
    public Major update(@RequestBody UpdateMajorDTO major, @PathVariable int id) {
        return majorService.update(major, id);
    }

    @DeleteMapping("id")
    public void delete(@PathVariable int id) {
        majorService.delete(id);
    }


}
