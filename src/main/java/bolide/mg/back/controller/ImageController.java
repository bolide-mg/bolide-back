package bolide.mg.back.controller;

import bolide.mg.back.model.Image;
import bolide.mg.back.service.ImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Image")
public class ImageController {
  private final ImageService imageService;

  @GetMapping("/{id}")
  public ResponseEntity<Image> findImageById(@PathVariable Integer id) {
    return ResponseEntity.ok(imageService.findImagesById(id));
  }

  @GetMapping("/car/{carId}")
  public ResponseEntity<List<Image>> findImageByCarId(@PathVariable Integer carId) {
    return ResponseEntity.ok(imageService.findImagesByCarId(carId));
  }

  //TODO
  @PostMapping("/car")
  public ResponseEntity<Image> assignImageToCar(@RequestBody Image image) {
    throw new RuntimeException("Not Implemented");
  }
}
