package creatives.personastorage.Services;

import creatives.personastorage.Models.PersonaImageObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImplementation {

  private enum ResourceType {
    FILE_SYSTEM,
    CLASSPATH
  }

  private static final String FILE_DIRECTORY = "src/main/resources/uploads/";

}
