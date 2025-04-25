package ua.opnu.practice1_template.controller;


import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entity.Doctor;
import ua.opnu.practice1_template.entity.Patient;
import ua.opnu.practice1_template.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final  DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/specialty")
    public List<Doctor> getDoctorsBySpecialty(@RequestParam long id){
        return doctorService.getDoctorsBySpecialty(id);
    }

//    @GetMapping("/{id}")
//    public Doctor getDoctorById(@PathVariable long id){
//        return doctorService.getDoctorByID(id);
//    }

    @GetMapping("/patients")
    public List<Patient> getPatientsById(@RequestParam long id){
        return doctorService.getPatientsByDoctorId(id);
    }

    @GetMapping("/patients_count")
    public int getPatientsCountById(@RequestParam long id){
        return doctorService.countPatients(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor){
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
    }


}
