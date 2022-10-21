package creatives.personastorage.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import creatives.personastorage.Links.PersonaStorageLinks;
import creatives.personastorage.Models.PersonaObject;
import creatives.personastorage.Services.PersonaDataServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Slf4j
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class PersonaStorageController {

  PersonaDataServiceImplementation service = new PersonaDataServiceImplementation();


  @GetMapping(path= PersonaStorageLinks.GET_PERSONAS)
  public ResponseEntity<?> getPersonas() throws JsonProcessingException { // Retrieve Personas
    log.info("fetching personas ....");
    System.out.println("fetching personas ....");
    if(service.getPersonas() == null){
      return ResponseEntity.ok("null");
      /*return ResponseEntity.ok("{\"name\":\"null\",\"gender\":\"null\",\"hair_color\":\"null\"," +
        "\"hair_length\":\"null\",\"hair_description\":\"null\",\"eye_color\":\"null\",\"head_shape\":\"null\"," +
        "\"height\":\"null\",\"body_type\":\"null\"}");*/
    }else {
      ArrayList<PersonaObject> personas = service.getPersonas();
      String retString = service.personaListToJSON(personas);
      return ResponseEntity.ok(retString);
    }
  }


  @PostMapping(path= PersonaStorageLinks.ADD_PERSONA)
  public ResponseEntity<?> addPersona(@RequestBody String personaJSON) throws JsonProcessingException {
    log.info("Retrieved: "+personaJSON);
    System.out.println("Retrieved: "+personaJSON);
    service.addPersona(personaJSON);
    return ResponseEntity.ok().body("{}");
  }
  @PostMapping(path= PersonaStorageLinks.EDIT_PERSONA)
  public ResponseEntity<?> editPersona(@RequestBody String personaJSON) throws JsonProcessingException {
    log.info("Editing: "+personaJSON);
    System.out.println("Editing: "+personaJSON);
    service.editPersona(personaJSON);
    return ResponseEntity.ok().body("{}");
  }

}
