import { Component, OnInit } from '@angular/core';
import { Persona } from '../persona';
import { PersonaDataService } from '../persona-data.service';

@Component({
  selector: 'app-persona-form',
  templateUrl: './persona-form.component.html',
  styleUrls: ['./persona-form.component.css']
})
export class PersonaFormComponent implements OnInit {

  hair_length = ["short", "medium", "long"]

  submitted = false;

  model = new Persona("Jane", "female", "red","long","wavy","blue", "round", "short", "skinny");

  constructor(private personaDataService: PersonaDataService) { }

  storePersona(){
    this.personaDataService.savePersonaData(this.model);
  }

  onSubmit(){
    this.submitted = true;
  }

  newPersona(){
    this.model = new Persona("", "", "","","","", "", "", "")
  }

  ngOnInit(): void {
  }

}
