package bolide.mg.back.repository;

import bolide.mg.back.model.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
  List<Car> findCarsByNameOrBrandOrModelOrMotorType(
      String name, String brand, String model, String motorType);

  List<Car> findCarsByStatus(Integer status);
}
