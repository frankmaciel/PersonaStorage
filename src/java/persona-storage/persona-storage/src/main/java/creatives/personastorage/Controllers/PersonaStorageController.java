package creatives.personastorage.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import creatives.personastorage.Links.PersonaStorageLinks;
import creatives.personastorage.Models.PersonaImageObject;
import creatives.personastorage.Models.PersonaObject;
import creatives.personastorage.Services.PersonaDataServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    }else {
      ArrayList<PersonaObject> personas = service.getPersonas();
      String retString = service.personaListToJSON(personas);
      return ResponseEntity.ok().body(retString);
    }
  }

  @PostMapping(path= PersonaStorageLinks.ADD_PERSONA)
  public ResponseEntity<?> addPersona(@RequestParam("image") MultipartFile image, @RequestParam("persona") String personaJSON) throws JsonProcessingException {
    log.info("Retrieved: "+personaJSON);
    System.out.println("Retrieved: "+personaJSON);
    service.addPersona(personaJSON.toString());
    service.addPersonaImage(image);
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
