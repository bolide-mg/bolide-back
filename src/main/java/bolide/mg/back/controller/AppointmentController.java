package bolide.mg.back.controller;

import bolide.mg.back.model.Appointment;
import bolide.mg.back.service.AppointmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/appointment")
public class AppointmentController {
  private final AppointmentService appointmentService;

  @GetMapping
  public ResponseEntity<List<Appointment>> findAllAppointment() {
    return ResponseEntity.ok(appointmentService.findAllAppointment());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Appointment> findAppointmentById(@PathVariable Integer id) {
    return ResponseEntity.ok(appointmentService.findAppointmentById(id));
  }

  @PutMapping
  public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment Appointment) {
    return ResponseEntity.ok(appointmentService.saveAppointment(Appointment));
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Appointment> deleteAppointment(@RequestBody Appointment Appointment) {
    return ResponseEntity.ok(appointmentService.deleteAppointment(Appointment));
  }
}
