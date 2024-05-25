package bolide.mg.back.controller;

import bolide.mg.back.model.Car;
import bolide.mg.back.service.CarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
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

  @PutMapping
  public ResponseEntity<Car> saveCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.saveCar(car));
  }

  @PutMapping("/delete")
  public ResponseEntity<Car> deleteCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.deleteCar(car));
  }
}
