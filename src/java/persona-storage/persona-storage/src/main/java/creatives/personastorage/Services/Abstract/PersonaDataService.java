package creatives.personastorage.Services.Abstract;

import com.fasterxml.jackson.core.JsonProcessingException;
import creatives.personastorage.Models.PersonaImageObject;
import creatives.personastorage.Models.PersonaObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface PersonaDataService {

  abstract void addPersona(String JSONStringToAdd) throws JsonProcessingException;
  abstract ArrayList<PersonaObject> getPersonas();
  public void editPersona(String JSONStringToAdd) throws JsonProcessingException;
  // Need a Delete Persona Soon

}
