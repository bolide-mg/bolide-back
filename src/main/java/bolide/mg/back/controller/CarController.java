package bolide.mg.back.controller;

import bolide.mg.back.model.Car;
import bolide.mg.back.service.CarService;
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

  @GetMapping
  public ResponseEntity<List<Car>> findAllCar() {
    return ResponseEntity.ok(carService.findAllCar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> findCarById(@PathVariable Integer id) {
    return ResponseEntity.ok(carService.findCarById(id));
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
