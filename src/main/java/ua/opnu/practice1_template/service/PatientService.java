package ua.opnu.practice1_template.service;


import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entity.Doctor;
import ua.opnu.practice1_template.entity.Patient;
import ua.opnu.practice1_template.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientByID(long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(long id,Patient patient){
        Patient existing = getPatientByID(id);
        existing.setFullName(patient.getFullName());
        existing.setBirthDate(patient.getBirthDate());
        existing.setEmail(patient.getEmail());
        existing.setPhone(patient.getPhone());
        return patientRepository.save(existing);
    }

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }

}
