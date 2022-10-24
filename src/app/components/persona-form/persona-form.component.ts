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


  image: File = new File([],"")

  imgName:string = ""

  submitted = false;

  model = new Persona(0,"Jane", "Young" ,"female", "red","long","wavy","blue", "round", "short", "skinny", this.image);

  constructor(private personaDataService: PersonaDataService) { }

  storePersona(){
    this.personaDataService.savePersonaData(this.model);
  }
  refreshPersona(){
    this.personaDataService.refreshPersonaData();
  }

  onSubmit(){
    this.submitted = true;
  }

  newPersona(){
    this.model = new Persona(0,"","", "", "","","","", "", "", "", this.image) 
  }

  setImage(imageToSet : File){
    this.image = imageToSet
    this.model.image = imageToSet
    this.imgName = imageToSet.name
  }

  ngOnInit(): void {
  }

}
