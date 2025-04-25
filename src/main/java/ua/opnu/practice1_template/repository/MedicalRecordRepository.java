package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.opnu.practice1_template.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {

    @Query("select m from MedicalRecord m where m.patient.id = :patientId")
    List<MedicalRecord> findMedicalRecordByPatient(@Param("patientId") Long id);

}
