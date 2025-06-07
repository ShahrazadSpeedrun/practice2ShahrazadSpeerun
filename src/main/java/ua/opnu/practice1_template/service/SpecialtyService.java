package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entity.Specialty;
import ua.opnu.practice1_template.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialityRepository) {
        this.specialtyRepository = specialityRepository;
    }

    public List<Specialty> getAllSpecialties(){
        return specialtyRepository.findAll();
    }

    public double getSpeciltyAverage(long id){
        double q = specialtyRepository.countBySpecialty(id);
        double w = specialtyRepository.countAllAppointments();
        return q/w;
    }



    public Specialty addSpecialty(Specialty specialty){
        return specialtyRepository.save(specialty);
    }



}
