package bolide.mg.back.repository;

import bolide.mg.back.model.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
  List<Image> findImagesByCarId(Integer carId);

  List<Image> findImagesByFileName(String fileName);
}
