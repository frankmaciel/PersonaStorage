package creatives.personastorage.Services.Abstract;

import creatives.personastorage.Models.PersonaImageObject;


public interface FileService {
  abstract void uploadImage(PersonaImageObject imageToAdd);
}
