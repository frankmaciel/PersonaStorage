import { personaInterface } from "./persona-interface";

export class Persona implements personaInterface {

    constructor(
      public name: string,
      public gender: string, // male, female, cisgendered, trans, etc.,
      public hairColor: string, // red, blue, etc ...
      public hairLength: string, // short, medium, long
      public hairDescription: string, // Wavy, curly, straight etc.,
      public eyeColor: string, // red, blue, etc ...
      public headShape: string, // Round, square, well defined etc,
      public height: string, //tall, short average height, etc.,
      public bodyType: string, // Scrawny, buff, bulky, etc.,
    ) {  }
  
  }