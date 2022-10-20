import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-persona-info',
  templateUrl: './persona-info.component.html',
  styleUrls: ['./persona-info.component.css']
})
export class PersonaInfoComponent implements OnInit {

  constructor() { }

  persona: any
  
  ngOnInit(): void {
  }

}
