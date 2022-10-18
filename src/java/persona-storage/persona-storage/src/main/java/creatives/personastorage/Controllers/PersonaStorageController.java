package creatives.personastorage.Controllers;

import creatives.personastorage.Links.PersonaStorageLinks;
import creatives.personastorage.Services.PersonaDataServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class PersonaStorageController {

  PersonaDataServiceImplementation service = new PersonaDataServiceImplementation();

  @GetMapping(path= PersonaStorageLinks.GET_PERSONAS)
  public ResponseEntity<?> getPersonas(){ // Retrieve Personas
    log.info("fetching personas ....");
    System.out.println("fetching personas ....");
    if(service.getPersonas() == null){
      return ResponseEntity.ok("{\"personas\":\"null\"}");
    }
    return ResponseEntity.ok("{}");
  }

}
