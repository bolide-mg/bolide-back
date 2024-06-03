package bolide.mg.back.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Value;

/** DTO for {@link Image} */
@Value
public class ImageDto implements Serializable {
  Integer id;
  Integer carId;
  String fileName;
  @NotNull @NotEmpty @NotBlank String url;
}
