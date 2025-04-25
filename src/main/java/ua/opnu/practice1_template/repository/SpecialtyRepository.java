package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.opnu.practice1_template.entity.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {

    @Query("select count(a) from Appointment a where a.doctor.specialty.id = :specialtyId")
    double countBySpecialty(@Param("specialtyId") Long specialtyId);

    @Query("select count(b) from Appointment b")
    double countAllAppointments();
}
