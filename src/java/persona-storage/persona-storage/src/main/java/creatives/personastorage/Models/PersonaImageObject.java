package creatives.personastorage.Models;

import org.springframework.web.multipart.MultipartFile;

public class PersonaImageObject {
  private MultipartFile imagefile;
  private int id;

  public MultipartFile getImagefile() {
    return imagefile;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setImagefile(MultipartFile imagefile) {
    this.imagefile = imagefile;
  }
}
