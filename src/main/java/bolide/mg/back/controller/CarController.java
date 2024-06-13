package bolide.mg.back.controller;

import bolide.mg.back.model.Car;
import bolide.mg.back.model.Image;
import bolide.mg.back.service.CarService;
import bolide.mg.back.service.ImageService;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
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
  public ResponseEntity<List<Car>> findAllCar(HttpServletResponse response) {
    List<Car> cars = carService.findAllCar();
    response.setHeader("X-Total-Count", String.valueOf(cars.size()));
    return ResponseEntity.ok(cars);
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

  @GetMapping("/brand")
  public ResponseEntity<List<String>> getBrands() {
    return ResponseEntity.ok(carService.getBrand());
  }

  @GetMapping("/search")
  public ResponseEntity<List<Car>> findCarsByParameters(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String brand,
      @RequestParam(required = false) String model,
      @RequestParam(required = false) String motorType,
      @RequestParam(required = false) String type) {
    return ResponseEntity.ok(carService.findCarsByParameters(name, brand, model, motorType, type));
  }

  @GetMapping("/search/price")
  public ResponseEntity<List<Car>> findCarsByPrice(
      @RequestParam Double minPrice, @RequestParam Double maxPrice) {
    return ResponseEntity.ok(carService.findCarsByPrice(minPrice, maxPrice));
  }

  @PutMapping
  public ResponseEntity<Car> saveCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.saveCar(car));
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Car> deleteCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.deleteCar(car));
  }
}
