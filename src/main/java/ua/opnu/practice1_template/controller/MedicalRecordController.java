package ua.opnu.practice1_template.controller;

import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entity.MedicalRecord;
import ua.opnu.practice1_template.service.MedicalRecordService;

import java.util.List;

@RestController
@RequestMapping("/records")
public class MedicalRecordController {
    private MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    public List<MedicalRecord> getAllRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecord(@PathVariable long id) {
        return medicalRecordService.getMedicalRecordById(id);
    }

    @GetMapping("/patient")
    public List<MedicalRecord> getMedicalRecordByPatient(@RequestParam long id) {
        return medicalRecordService.getMedicalRecordByPatient(id);
    }



    @PostMapping
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }

    @PutMapping("/{id}")
    public MedicalRecord updateMedicalRecord(@RequestBody long id,@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.updateMedicalRecord(id, medicalRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalRecord(@PathVariable long id) {
        medicalRecordService.deleteMedicalRecord(id);
    }

}
