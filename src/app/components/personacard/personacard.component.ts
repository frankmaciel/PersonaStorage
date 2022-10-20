import { Component, Input, OnInit } from '@angular/core';
import { Persona } from '../persona';
import { PersonaDataService } from '../persona-data.service';

@Component({
  selector: 'app-personacard',
  templateUrl: './personacard.component.html',
  styleUrls: ['./personacard.component.css']
})
export class PersonacardComponent implements OnInit {

  personas: any

  constructor(private personaDataService: PersonaDataService) { 
    
  }

  ngOnInit(): void {
    this.personaDataService.personas.subscribe((persona: any) => {this.personas = persona})
  }

}
