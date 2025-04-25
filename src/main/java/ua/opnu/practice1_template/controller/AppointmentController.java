package ua.opnu.practice1_template.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entity.Appointment;
import ua.opnu.practice1_template.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getFilteredAppointments(
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) Long patientId,
            @RequestParam(required = false) Boolean future) {

        return appointmentService.getFilteredAppointments(doctorId, patientId,future);
    }

    @GetMapping("/{dateTime}")
    public  List<Appointment> getAppointmentsByDateTime(@PathVariable LocalDateTime dateTime){
        return appointmentService.getAppointmentsBtDate(dateTime);
    }


    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable long id, @RequestBody Appointment appointment){
        appointment.setId(id);  // Make sure the ID from the URL is set on the appointment
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable long id){
        appointmentService.deleteAppoinment(id);

    }
}
