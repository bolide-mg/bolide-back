package bolide.mg.back.service;

import bolide.mg.back.model.Image;
import bolide.mg.back.repository.ImageRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
  private final ImageRepository imageRepository;

  public ImageService(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public Image findImagesById(Integer id) {
    return imageRepository.findById(id).orElse(null);
  }

  public List<Image> findImagesByCarId(Integer carId) {
    return imageRepository.findImagesByCarId(carId);
  }
}
