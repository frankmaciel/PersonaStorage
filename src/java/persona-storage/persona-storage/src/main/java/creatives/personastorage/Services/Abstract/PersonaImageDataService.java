package creatives.personastorage.Services.Abstract;

import creatives.personastorage.Models.PersonaImageObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface PersonaImageDataService {

  abstract ArrayList<PersonaImageObject> getImageList();
  abstract void addToImageList(PersonaImageObject pImage);
  abstract void addPersonaImage(MultipartFile imageToAdd, int id);


}
