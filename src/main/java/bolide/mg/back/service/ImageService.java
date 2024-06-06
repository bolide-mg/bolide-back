package bolide.mg.back.service;

import bolide.mg.back.model.Car;
import bolide.mg.back.model.Image;
import bolide.mg.back.repository.CarRepository;
import bolide.mg.back.repository.ImageRepository;
import java.time.Duration;
import java.util.List;
import org.springframework.http.*;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ImageService {
  private final ImageRepository imageRepository;
  private final CarRepository carRepository;

  public ImageService(ImageRepository imageRepository, CarRepository carRepository) {
    this.imageRepository = imageRepository;
    this.carRepository = carRepository;
  }

  public Image findImagesById(Integer id) {
    return imageRepository.findById(id).orElse(null);
  }

  public List<Image> findImagesByCarId(Integer carId) {
    return imageRepository.findImagesByCarId(carId);
  }

  public Image saveImage(MultipartFile file, Integer carId) {
    String fileName = file.getOriginalFilename();
    List<Image> existingImages = imageRepository.findImagesByFileName(fileName);

    Car car = carRepository.findById(carId).orElse(null);

    String imageUrl = System.getenv("SUPABASE_URL") + "/storage/v1/object/public/" + fileName;

    WebClient webClient =
        WebClient.builder()
            .baseUrl(System.getenv("SUPABASE_URL"))
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + System.getenv("SUPABASE_KEY"))
            .build();

    MultipartBodyBuilder builder = new MultipartBodyBuilder();
    builder.part("file", file.getResource());

    if (!existingImages.isEmpty()) {
      for (Image existingImage : existingImages) {
        if (existingImage.getCar().getId().equals(carId)) {
          // Image already exists and is associated with the same car ID
          // Return the existing image
          return existingImage;
        }
      }

      // If the code reaches here, it means the image exists but is associated with a different car
      // ID

      Image newImage = new Image();
      newImage.setFileName(fileName);
      newImage.setUrl(imageUrl);
      newImage.setCar(car);
      return imageRepository.save(newImage);
    }

    // If the code reaches here, it means the image doesn't exist

    Mono<String> responseMono =
        webClient
            .post()
            .uri(
                uriBuilder ->
                    uriBuilder.path("/storage/v1/object/Images/{fileName}").build(fileName))
            .body(BodyInserters.fromMultipartData(builder.build()))
            .retrieve()
            .bodyToMono(String.class);

    String response = responseMono.block(Duration.ofSeconds(90));
    System.out.println(response); // Block until the response is received

    Image image = new Image();
    image.setFileName(fileName);
    image.setUrl(imageUrl);
    image.setCar(car);
    return imageRepository.save(image);
  }
}
