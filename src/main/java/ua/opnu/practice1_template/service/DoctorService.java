package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entity.Doctor;
import ua.opnu.practice1_template.entity.Patient;
import ua.opnu.practice1_template.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors(){
       return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsBySpecialty(long id){
        return doctorRepository.getDoctorsBySpecialtyId(id);
    }

    public Doctor getDoctorByID(long id){
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public List<Patient> getPatientsByDoctorId(long id){
        return doctorRepository.getPatientsByDoctorId(id);
    }

    public int countPatients(long id){
        return doctorRepository.countPatientsByDoctorId(id);
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(long id,Doctor doctor){
        Doctor existing = getDoctorByID(id);
        existing.setFullName(doctor.getFullName());
        existing.setSpecialty(doctor.getSpecialty());
        existing.setEmail(doctor.getEmail());
        return doctorRepository.save(existing);
    }

    public void deleteDoctor(long id){
        doctorRepository.deleteById(id);
    }

}
