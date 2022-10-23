import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Persona } from '../persona';
import { PersonaDataService } from '../persona-data.service';
import { PersonaInfoComponent } from '../persona-info/persona-info.component';

@Component({
  selector: 'app-personacard',
  templateUrl: './personacard.component.html',
  styleUrls: ['./personacard.component.css']
})
export class PersonacardComponent implements OnInit {

  personas: any
  url:string = "http://localhost:8080/uploads/images/"
  constructor(private personaDataService: PersonaDataService, private DialogRef: MatDialog) { 
    
  }

  
  imageURL(id: string){
    return this.url + id + ".jpeg"
  }

  openPersonaDialog(persona:any){
    let dialogref = this.DialogRef.open(PersonaInfoComponent)
    dialogref.componentInstance.persona = persona;
    dialogref.afterClosed().subscribe(result => this.personaDataService.refreshPersonaData())
  }

  ngOnInit(): void {
    this.personaDataService.personas.subscribe((persona: any) => {this.personas = persona})
  }

}
