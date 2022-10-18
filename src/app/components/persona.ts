import { personaInterface } from "./persona-interface";

export class Persona implements personaInterface {

    constructor(
      public name: string,
      public gender: string, // male, female, cisgendered, trans, etc.,
      public hair_color: string, // red, blue, etc ...
      public hair_length: string, // short, medium, long
      public hair_description: string, // Wavy, curly, straight etc.,
      public eye_color: string, // red, blue, etc ...
      public head_shape: string, // Round, square, well defined etc,
      public height: string, //tall, short average height, etc.,
      public body_type: string, // Scrawny, buff, bulky, etc.,
    ) {  }
  
  }