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
    //Use the two helper functions to turn a JSON String into a HashMap
    //And then into a Persona Object
    if(personaList == null){
      personaList = new ArrayList<>();
    }
    PersonaObject persona = JsonToPersona(JSONStringToAdd);
    personaList.add(persona);
  }

  @Override
  public ArrayList<PersonaObject> getPersonas() {
    return personaList;
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
    persona.setName((String) mapping.get("name"));
    persona.setGender((String) mapping.get("gender"));
    persona.setHairColor((String) mapping.get("hair_color"));
    persona.setHairLength((String) mapping.get("hair_length"));
    persona.setHairDescription((String) mapping.get("hair_description"));
    persona.setEyeColor((String) mapping.get("eye_color"));
    persona.setHeadShape((String) mapping.get("head_shape"));
    persona.setHeight((String) mapping.get("height"));
    persona.setBodyType((String) mapping.get("body_type"));
    return persona;
  }
}
