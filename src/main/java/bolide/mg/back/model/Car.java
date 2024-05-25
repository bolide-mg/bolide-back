package bolide.mg.back.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_gen")
  @SequenceGenerator(name = "car_id_gen", sequenceName = "car_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Size(max = 50)
  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "description", length = Integer.MAX_VALUE)
  private String description;

  @Size(max = 50)
  @Column(name = "brand", length = 50)
  private String brand;

  @Size(max = 50)
  @Column(name = "model", length = 50)
  private String model;

  @Column(name = "price")
  private Double price;

  @Size(max = 70)
  @Column(name = "color", length = 70)
  private String color;

  @Size(max = 100)
  @Column(name = "motor_type", length = 100)
  private String motorType;

  @Column(name = "power")
  private Double power;

  @Column(name = "place_number")
  private Integer placeNumber;

  @ColumnDefault("0")
  @Column(name = "status")
  private Integer status;

  @Size(max = 50)
  @Column(name = "type", length = 50)
  private String type;
}
