package creatives.personastorage.Services.Abstract;

import com.fasterxml.jackson.core.JsonProcessingException;
import creatives.personastorage.Models.PersonaObject;

import java.util.ArrayList;

public interface PersonaDataService {

  abstract void addPersona(String JSONStringToAdd) throws JsonProcessingException;

  abstract ArrayList<PersonaObject> getPersonas();



}
