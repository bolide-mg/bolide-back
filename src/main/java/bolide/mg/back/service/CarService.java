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

  public List<Car> findCarsByParameters(String name, String brand, String model, String motorType) {
    return carRepository.findCarsByNameOrBrandOrModelOrMotorTypeIgnoreCase(
        name, brand, model, motorType);
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
}
