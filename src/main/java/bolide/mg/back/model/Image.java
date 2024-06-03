package bolide.mg.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_id_gen")
  @SequenceGenerator(name = "images_id_gen", sequenceName = "images_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "file_name", length = Integer.MAX_VALUE)
  private String fileName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "car_id")
  private Car car;

  @Column(name = "url", length = Integer.MAX_VALUE)
  private String url;
}
