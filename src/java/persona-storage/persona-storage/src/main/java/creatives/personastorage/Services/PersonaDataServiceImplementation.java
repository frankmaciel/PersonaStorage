package creatives.personastorage.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import creatives.personastorage.Models.PersonaObject;
import creatives.personastorage.Services.Abstract.PersonaDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonaDataServiceImplementation implements PersonaDataService {

  private ArrayList<PersonaObject> personaList = null;

  @Override
  public void addPersona(String JSONStringToAdd) throws JsonProcessingException {
    if(personaList == null){
      personaList = new ArrayList<>();
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
}
