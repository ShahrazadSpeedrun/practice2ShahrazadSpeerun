package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entity.MedicalRecord;
import ua.opnu.practice1_template.repository.MedicalRecordRepository;

import java.util.List;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public List<MedicalRecord> getAllMedicalRecords(){
        return medicalRecordRepository.findAll();
    }

    public List<MedicalRecord> getMedicalRecordByPatient(long id){
        return medicalRecordRepository.findMedicalRecordByPatient(id);
    }

    public MedicalRecord getMedicalRecordById(long id){
        return medicalRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Medical Record not found"));
    }

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord updateMedicalRecord(long id,MedicalRecord medicalRecord){
        MedicalRecord existing = getMedicalRecordById(id);
        existing.setTreatment(medicalRecord.getTreatment());
        existing.setCreatedAt(medicalRecord.getCreatedAt());
        existing.setDiagnosis(medicalRecord.getDiagnosis());
        return medicalRecordRepository.save(existing);
    }

    public void deleteMedicalRecord(long id){
        medicalRecordRepository.deleteById(id);
    }

}
