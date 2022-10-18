package creatives.personastorage.Models;

import creatives.personastorage.Models.Abstract.PersonaObjectAbstract;

public class PersonaObject implements PersonaObjectAbstract {

  private String name = null;
  private String gender = null;
  private String hairColor = null;
  private String hairLength = null;
  private String hairDescription = null;
  private String eyeColor = null;
  private String headShape = null;
  private String height = null;
  private String bodyType = null;

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getGender() {
    return this.gender;
  }

  @Override
  public String getHairColor() {
    return this.hairColor;
  }

  @Override
  public String getHairLength() {
    return this.hairLength;
  }

  @Override
  public String getHairDescription() {
    return this.hairDescription;
  }

  @Override
  public String getEyeColor() {
    return this.eyeColor;
  }

  @Override
  public String getHeadShape() {
    return this.headShape;
  }

  @Override
  public String getHeight() {
    return this.height;
  }

  @Override
  public String getBodyType() {
    return this.bodyType;
  }

  @Override
  public void setName(String toSet) {
    this.name = toSet;
  }

  @Override
  public void setGender(String toSet) {
    this.gender = toSet;
  }

  @Override
  public void setHairColor(String toSet) {
    this.hairColor = toSet;
  }

  @Override
  public void setHairLength(String toSet) {
    this.hairLength = toSet;
  }

  @Override
  public void setHairDescription(String toSet) {
    this.hairDescription = toSet;
  }

  @Override
  public void setEyeColor(String toSet) {
    this.eyeColor = toSet;
  }

  @Override
  public void setHeadShape(String toSet) {
    this.headShape = toSet;
  }

  @Override
  public void setHeight(String toSet) {
    this.height = toSet;
  }

  @Override
  public void setBodyType(String toSet) {
    this.bodyType = toSet;
  }
}
