package com.edu.uni.doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAll();
    }

    @GetMapping("{id}")
    public Doctor getById(@PathVariable int id) {
        return doctorService.getById(id);
    }

    @PostMapping("")
    public Doctor add(@RequestBody AddDoctorDTO doctor) {
        return doctorService.save(doctor);
    }

    @PutMapping("{id}")
    public Doctor update(@RequestBody UpdateDoctorDTO doctor, @PathVariable int id) {
        return doctorService.update(doctor,id);
    }

@DeleteMapping("id")
public void delete(@PathVariable ("id") int id) {
   doctorService.delete(id);
}
}
