package creatives.personastorage.Services;
import creatives.personastorage.Models.PersonaImageObject;
import creatives.personastorage.Services.Abstract.FileService;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImplementation implements FileService {

  /**
   * Takes a PersonaImageObject and uploads the MultipartFile Image
   * to the uploads folder
   * @param imageToAdd
   */
  public void uploadImage(PersonaImageObject imageToAdd) {
    String url = "uploads/";
    if (imageToAdd.getImagefile().getOriginalFilename() != "") {
      try {
        Path root = Paths.get(url + "images/");
        Files.copy(imageToAdd.getImagefile().getInputStream(), root.resolve(imageToAdd.getId() + ".jpeg"), StandardCopyOption.REPLACE_EXISTING);
      } catch (Exception e) {
        throw new RuntimeException(" Could not store the file. Error: " + e.getMessage());
      }
    }else {
      try {
        Path rootFile = Paths.get(url + "default.jpeg");
        Path root = Paths.get(url + "images/");
        Files.copy(rootFile,root.resolve(imageToAdd.getId() + ".jpeg"),StandardCopyOption.REPLACE_EXISTING);
      } catch (Exception e) {
        throw new RuntimeException(" Could not store the file. Error: " + e.getMessage());
      }
    }
  }

}
