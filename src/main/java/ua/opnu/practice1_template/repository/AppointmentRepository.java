package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.opnu.practice1_template.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query("select a FROM Appointment a where a.dateTime = :dateTime")
    List<Appointment> findByDate(@Param("dateTime") LocalDateTime dateTime);

    @Query("SELECT a FROM Appointment a WHERE " +
            "(:doctorId IS NULL OR a.doctor.id = :doctorId) " +
            "AND (:patientId IS NULL OR a.patient.id = :patientId) " +
            "AND (:future is null or a.dateTime > CURRENT DATE )")
    List<Appointment> getFilteredAppointments(
            @Param("doctorId") Long doctorId,
            @Param("patientId") Long patientID,
            @Param("future") Boolean future);
}

