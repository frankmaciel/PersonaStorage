import { Component, OnInit } from '@angular/core';
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

  onSubmit(){
    this.edit = true;
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
