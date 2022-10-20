import { Component, OnInit } from '@angular/core';
import { PersonaDataService } from '../persona-data.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(private service: PersonaDataService) { }

  ngOnInit(): void {
  }

}
