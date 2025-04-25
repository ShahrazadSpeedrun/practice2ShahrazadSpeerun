package ua.opnu.practice1_template.controller;


import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entity.Patient;
import ua.opnu.practice1_template.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

//    @GetMapping("/{id}")
//    public Patient getPatientById(@PathVariable long id){
//        return patientService.getPatientByID(id);
//    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable long id, Patient patient) {
        return patientService.updatePatient(id,patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
    }
}
