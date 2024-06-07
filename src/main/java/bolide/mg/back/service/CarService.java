package bolide.mg.back.service;

import bolide.mg.back.model.Car;
import bolide.mg.back.repository.CarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {
  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<Car> findAllCar() {
    return carRepository.findAll();
  }

  public Car findCarById(Integer id) {
    return carRepository.findById(id).orElse(null);
  }

  public List<Car> findCarsByParameters(
      String name, String brand, String model, String motorType, String type) {
    if (name == null && brand == null && model == null && motorType == null && type == null) {
      return findAllCar();
    }

    String nameParam = name != null && !name.isEmpty() ? name : null;
    String brandParam = brand != null && !brand.isEmpty() ? brand : null;
    String modelParam = model != null && !model.isEmpty() ? model : null;
    String motorTypeParam = motorType != null && !motorType.isEmpty() ? motorType : null;
    String typeParam = type != null && !type.isEmpty() ? type : null;

    return carRepository
        .findByNameContainingIgnoreCaseOrBrandContainingIgnoreCaseOrModelContainingIgnoreCaseOrMotorTypeContainingIgnoreCaseOrTypeContainingIgnoreCase(
            nameParam, brandParam, modelParam, motorTypeParam, typeParam);
  }

  public List<Car> findTrendingCars(Integer status) {
    return carRepository.findCarsByStatus(status);
  }

  public Car saveCar(Car Car) {
    return carRepository.save(Car);
  }

  public Car deleteCar(Car car) {
    Car currentCar = findCarById(car.getId());
    carRepository.delete(car);
    return currentCar;
  }

  public List<Car> findCarsByPrice(Double minPrice, Double maxPrice) {
    return carRepository.findCarsByPriceBetween(minPrice, maxPrice);
  }
}
