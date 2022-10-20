import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonacardComponent } from './components/personacard/personacard.component';
import {MatCardModule} from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddPersonaComponent } from './components/add-persona/add-persona.component';
import {MatIconModule} from '@angular/material/icon';

import { MatDialogModule} from '@angular/material/dialog';
import { PersonaFormComponent } from './components/persona-form/persona-form.component'

import { FormsModule } from "@angular/forms"

import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    PersonacardComponent,
    AddPersonaComponent,
    PersonaFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatDialogModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [PersonaFormComponent]
  
})
export class AppModule { }
