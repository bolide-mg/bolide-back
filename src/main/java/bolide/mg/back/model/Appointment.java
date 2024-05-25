package bolide.mg.back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_gen")
  @SequenceGenerator(
      name = "appointment_id_gen",
      sequenceName = "appointment_id_seq",
      allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Size(max = 50)
  @Column(name = "name", length = 50)
  private String name;

  @Size(max = 50)
  @Column(name = "first_name", length = 50)
  private String firstName;

  @Size(max = 50)
  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "message", length = Integer.MAX_VALUE)
  private String message;

  @Size(max = 20)
  @Column(name = "contact", length = 20)
  private String contact;

  @ColumnDefault("(now() + '14 days'::interval)")
  @Column(name = "appointment_date")
  private OffsetDateTime appointmentDate;

  @Size(max = 20)
  @Column(name = "status", length = 20)
  private String status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_car")
  private Car idCar;
}
