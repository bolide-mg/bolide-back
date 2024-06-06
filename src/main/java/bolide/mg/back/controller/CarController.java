package bolide.mg.back.controller;

import bolide.mg.back.model.Car;
import bolide.mg.back.model.Image;
import bolide.mg.back.service.CarService;
import bolide.mg.back.service.ImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/car")
public class CarController {
  private final CarService carService;
  private final ImageService imageService;

  @GetMapping
  public ResponseEntity<List<Car>> findAllCar() {
    return ResponseEntity.ok(carService.findAllCar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> findCarById(@PathVariable Integer id) {
    return ResponseEntity.ok(carService.findCarById(id));
  }

  @GetMapping("/{id}/images")
  public ResponseEntity<List<Image>> findImagesByCarId(@PathVariable Integer id) {
    return ResponseEntity.ok(imageService.findImagesByCarId(id));
  }

  @GetMapping("/trending")
  public ResponseEntity<List<Car>> findTrendingCar() {
    return ResponseEntity.ok(carService.findTrendingCars(1));
  }

  @GetMapping("/search")
  public ResponseEntity<List<Car>> findCarsByParameters(
      @RequestParam String name,
      @RequestParam String brand,
      @RequestParam String model,
      @RequestParam String motorType) {
    return ResponseEntity.ok(carService.findCarsByParameters(name, brand, model, motorType));
  }

  @PutMapping
  public ResponseEntity<Car> saveCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.saveCar(car));
  }

  @PutMapping("/delete")
  public ResponseEntity<Car> deleteCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.deleteCar(car));
  }
}
