package bolide.mg.back.controller;

import bolide.mg.back.model.Car;
import bolide.mg.back.model.Image;
import bolide.mg.back.model.ImageDto;
import bolide.mg.back.service.CarService;
import bolide.mg.back.service.ImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/Image")
public class ImageController {
  private final ImageService imageService;
  private final CarService carService;

  @GetMapping("/{id}")
  public ResponseEntity<Image> findImageById(@PathVariable Integer id) {
    return ResponseEntity.ok(imageService.findImagesById(id));
  }

  @GetMapping("/car/{carId}")
  public ResponseEntity<List<Image>> findImageByCarId(@PathVariable Integer carId) {
    return ResponseEntity.ok(imageService.findImagesByCarId(carId));
  }

  // TODO
  @PostMapping("/car/{carId}")
  public ResponseEntity<Image> assignImageToCar(
      @RequestBody Image image, @PathVariable Integer carId) {
    throw new RuntimeException("Not Implemented");
  }

  // TODO
  @PostMapping("/save")
  public ResponseEntity<Image> saveImage(@RequestBody ImageDto image) {
    Car car = carService.findCarById(image.getCarId());
    if (car == null) {
      return ResponseEntity.notFound().build();
    }
    Image registeredImage = new Image();
    registeredImage.setCar(car);
    // TODO : image should be uploaded before getting the url
    // https://supabase.github.io/storage/#/bucket
    // multipart form somewhere
    registeredImage.setUrl(image.getUrl());
    ResponseEntity.ok(imageService.saveImage(registeredImage));
    throw new RuntimeException("Not Implemented");
  }
}
