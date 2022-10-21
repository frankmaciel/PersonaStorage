package creatives.personastorage.Models.Abstract;

public interface PersonaObjectAbstract {
  abstract int getID();
  abstract String getName();
  abstract String getAge();
  abstract String getGender();
  abstract String getHairColor();
  abstract String getHairLength();
  abstract String getHairDescription();
  abstract String getEyeColor();
  abstract String getHeadShape();
  abstract String getHeight();
  abstract String getBodyType();
  abstract String getImage();

  abstract void setID(int toSet);
  abstract void setName(String toSet);
  abstract void setAge(String toSet);
  abstract void setGender(String toSet);
  abstract void setHairColor(String toSet);
  abstract void setHairLength(String toSet);
  abstract void setHairDescription(String toSet);
  abstract void setEyeColor(String toSet);
  abstract void setHeadShape(String toSet);
  abstract void setHeight(String toSet);
  abstract void setBodyType(String toSet);
  abstract void setImage(String toSet);

}
