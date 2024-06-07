package bolide.mg.back.controller;

import bolide.mg.back.model.Image;
import bolide.mg.back.service.ImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/images")
public class ImageController {
  private final ImageService imageService;

  @GetMapping
  public ResponseEntity<List<Image>> findAllImage() {
    return ResponseEntity.ok(imageService.findAllImage());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Image> findImageById(@PathVariable Integer id) {
    return ResponseEntity.ok(imageService.findImageById(id));
  }

  @GetMapping("/car/{carId}")
  public ResponseEntity<List<Image>> findImageByCarId(@PathVariable Integer carId) {
    return ResponseEntity.ok(imageService.findImagesByCarId(carId));
  }

  @PostMapping("/car/{carId}/save")
  public ResponseEntity<Image> saveImage(
      @RequestParam("file") MultipartFile file, @PathVariable Integer carId) {
    return ResponseEntity.ok(imageService.saveImage(file, carId));
  }
}
