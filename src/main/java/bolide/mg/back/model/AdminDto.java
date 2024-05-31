package bolide.mg.back.model;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Value;

/** DTO for {@link Admin} */
@Value
public class AdminDto implements Serializable {
  Integer id;

  @Size(max = 50)
  String email;

  @Size(max = 50)
  String name;
}
