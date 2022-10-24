import { Component, OnInit } from '@angular/core';
import { Persona } from '../persona';
import { PersonaDataService } from '../persona-data.service';

@Component({
  selector: 'app-persona-info',
  templateUrl: './persona-info.component.html',
  styleUrls: ['./persona-info.component.css']
})
export class PersonaInfoComponent implements OnInit {

  constructor(private personaDataService: PersonaDataService) { }

  edit = false;
  persona: any
  modelPersona: any

  url:string = "http://localhost:8080/uploads/images/"

  imageURL(id: string){
    return this.url + id + ".jpeg"
  }

  onSubmit(){
    this.edit = true;
  }

  setImage(image : File){
    this.persona.image = image
  }

  editUser(){
    this.personaDataService.editPersonaData(this.persona);
  }
  refreshPersona(){
    this.personaDataService.refreshPersonaData();
  }
  
  ngOnInit(): void {
  }

}
