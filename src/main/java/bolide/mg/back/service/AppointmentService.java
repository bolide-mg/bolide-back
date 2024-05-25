package bolide.mg.back.service;

import bolide.mg.back.model.Appointment;
import bolide.mg.back.repository.AppointmentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  public List<Appointment> findAllAppointment() {
    return appointmentRepository.findAll();
  }

  public Appointment findAppointmentById(Integer id) {
    return appointmentRepository.findById(id).orElse(null);
  }

  public Appointment saveAppointment(Appointment Appointment) {
    return appointmentRepository.save(Appointment);
  }

  public Appointment deleteAppointment(Appointment appointment) {
    Appointment currentAppointment = findAppointmentById(appointment.getId());
    appointmentRepository.delete(appointment);
    return currentAppointment;
  }
}
