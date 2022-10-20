import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PersonaFormComponent } from '../persona-form/persona-form.component';

@Component({
  selector: 'app-add-persona',
  templateUrl: './add-persona.component.html',
  styleUrls: ['./add-persona.component.css']
})
export class AddPersonaComponent implements OnInit {

  constructor( private DialogRef: MatDialog) { }
  
  openDialog(){
    this.DialogRef.open(PersonaFormComponent)
    
  }

  ngOnInit(): void {
  }

}
