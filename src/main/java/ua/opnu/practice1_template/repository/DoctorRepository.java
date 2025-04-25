package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.opnu.practice1_template.entity.Doctor;
import ua.opnu.practice1_template.entity.Patient;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query("select a.patient from Appointment a where a.doctor.id = :doctorId")
    List<Patient> getPatientsByDoctorId(@Param("doctorId") Long id);

    @Query("select d from Doctor d where d.specialty.id = :specialtyId")
    List<Doctor> getDoctorsBySpecialtyId(@Param("specialtyId") Long id);

    @Query("select count(a.patient) from Appointment a where a.doctor.id = :doctorId")
    int countPatientsByDoctorId(@Param("doctorId") Long id);

}
