package creatives.personastorage.Services;
import creatives.personastorage.Models.PersonaImageObject;
import creatives.personastorage.Services.Abstract.PersonaImageDataService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Service
public class PersonaImageDataServiceImplementation implements PersonaImageDataService {
  private FileServiceImplementation fileService = new FileServiceImplementation();
  private ArrayList<PersonaImageObject> imageList = null;

  /**
   * Returns the image list
   * @return
   */
  public ArrayList<PersonaImageObject> getImageList() {
    return imageList;
  }

  /**
   * Adds a PersonaImageObject to the list
   * @param pImage
   */
  public void addToImageList(PersonaImageObject pImage){
    imageList.add(pImage);
  }

  /**
   * Initializes image list; adds the MultipartFile image to the list.
   * Accesses file service to upload the image to the uploads folder.
   * @param imageToAdd
   * @param id
   */
  public void addPersonaImage(MultipartFile imageToAdd, int id) { // set the image in the list
    PersonaImageObject personaImage = new PersonaImageObject();
    personaImage.setId(id);
    personaImage.setImagefile(imageToAdd);
    if(imageList == null){
      initializeImageList();
    }
    fileService.uploadImage(personaImage);
    addToImageList(personaImage);
  }

  /*
      HELPER FUNCTIONS START---------------------------
   */

  private void initializeImageList(){
    imageList = new ArrayList<>();
  }

  /*
      HELPER FUNCTIONS END---------------------------
   */

}
