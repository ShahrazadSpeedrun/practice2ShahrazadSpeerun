package ua.opnu.practice1_template.controller;

import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entity.Specialty;
import ua.opnu.practice1_template.service.SpecialtyService;

import java.util.List;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/average")
    public double getSpecialtyAverage(@RequestParam long id) {
        return specialtyService.getSpeciltyAverage(id);
    }

//    @GetMapping("/{id}")
//    public Specialty getSpecialtyByID(@PathVariable long id){
//        return specialtyService.getSpecialtyById(id);
//    }

    @PostMapping
    public Specialty addSpecialty(@RequestBody Specialty specialty){
        return specialtyService.addSpecialty(specialty);
    }
//
//    @PutMapping
//    public Specialty updateSpecialty(long id , @RequestBody Specialty specialty){
//        return specialtyService.updateSpecialty(id,specialty);
//    }
//
//    @DeleteMapping
//    public void deleteSpecialty(long id){
//        specialtyService.deleteSpecialty(id);
//    }
}
