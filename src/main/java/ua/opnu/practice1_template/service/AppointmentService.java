package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entity.Appointment;
import ua.opnu.practice1_template.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    private final  AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getFilteredAppointments(Long doctorId, Long patientId , Boolean future) {
        return appointmentRepository.getFilteredAppointments(doctorId, patientId , future);
    }

    public List<Appointment> getAppointmentsBtDate(LocalDateTime dateTime){
        return appointmentRepository.findByDate(dateTime);
    }

    public Appointment  getAppointmentById(long id){
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment updated){
        Appointment existing = getAppointmentById(updated.getId());
        existing.setDateTime(updated.getDateTime());
        existing.setNotes(updated.getNotes());
        return appointmentRepository.save(existing);
    }

    public void deleteAppoinment(long id){
        appointmentRepository.deleteById(id);
    }

}
