package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
