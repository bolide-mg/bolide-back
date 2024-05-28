package bolide.mg.back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_id_gen")
  @SequenceGenerator(name = "admin_id_gen", sequenceName = "admin_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Size(max = 50)
  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "password", length = Integer.MAX_VALUE)
  private String password;

  @Size(max = 50)
  @Column(name = "name", length = 50)
  private String name;
}
