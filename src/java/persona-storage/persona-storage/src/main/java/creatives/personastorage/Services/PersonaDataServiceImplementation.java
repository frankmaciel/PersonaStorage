package creatives.personastorage.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import creatives.personastorage.Models.PersonaImageObject;
import creatives.personastorage.Models.PersonaObject;
import creatives.personastorage.Services.Abstract.PersonaDataService;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonaDataServiceImplementation implements PersonaDataService {

  private ArrayList<PersonaObject> personaList = null;
  private ArrayList<PersonaImageObject> imageList = null;
  private FileServiceImplementation fileService = new FileServiceImplementation();

  @Override
  public void addPersona(String JSONStringToAdd) throws JsonProcessingException {
    if(personaList == null){
      personaList = new ArrayList<>();
      imageList = new ArrayList<>();
      PersonaObject persona = JsonToPersona(JSONStringToAdd);
      persona.setID(0);
      personaList.add(persona);
    }else{
      PersonaObject persona = JsonToPersona(JSONStringToAdd);
      persona.setID(getNextID());
      personaList.add(persona);
    }
  }

  public void editPersona(String JSONStringToAdd) throws JsonProcessingException {
      PersonaObject persona = JsonToPersona(JSONStringToAdd);
      int id = persona.getID();
      for (PersonaObject p : personaList){
        if (p.getID() == id){
          personaList.remove(p);
          break;
        }
      }
      personaList.add(persona);
  }

  @Override
  public ArrayList<PersonaObject> getPersonas() {
    return personaList;
  }
  @Override
  public ArrayList<PersonaImageObject> getImages() {
    return imageList;
  }

  @Override
  public int getNextID() {
    int nextID = -1;
    if(personaList != null) {
      for (PersonaObject p : personaList) {
        if (p.getID() > nextID) {
          nextID = p.getID();
        }
      }
    }
    return nextID+1;
  }

  public String personaListToJSON(ArrayList<PersonaObject> personaObjList) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    String json = mapper.writeValueAsString(personaObjList);
    return json;
  }

  //Helper Functions ------------
  private PersonaObject JsonToPersona(String JSONString) throws JsonProcessingException {
    Map<String, Object> mapping = new ObjectMapper().readValue(JSONString, HashMap.class);
    PersonaObject persona = new PersonaObject();
    persona.setID((int) mapping.get("id"));
    persona.setName((String) mapping.get("name"));
    persona.setAge((String) mapping.get("age"));
    persona.setGender((String) mapping.get("gender"));
    persona.setHairColor((String) mapping.get("hairColor"));
    persona.setHairLength((String) mapping.get("hairLength"));
    persona.setHairDescription((String) mapping.get("hairDescription"));
    persona.setEyeColor((String) mapping.get("eyeColor"));
    persona.setHeadShape((String) mapping.get("headShape"));
    persona.setHeight((String) mapping.get("height"));
    persona.setBodyType((String) mapping.get("bodyType"));
    return persona;
  }

  @Override
  public void addPersonaImage(MultipartFile imageToAdd) { // set the image in the list
    int count = getRecentlyAddedUser();
    PersonaImageObject personaImage = new PersonaImageObject();
    personaImage.setId(count);
    personaImage.setImagefile(imageToAdd);
    uploadImage(personaImage);
    imageList.add(personaImage);
  }

  void uploadImage(PersonaImageObject imageToAdd) {
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

  int getRecentlyAddedUser(){
    int count = -1;
    for (PersonaObject p:
      personaList) {
      if(p.getID() > count){
        count = p.getID();
      }
    }
    return count;
  }
}
