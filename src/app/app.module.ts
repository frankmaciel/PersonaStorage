import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonacardComponent } from './components/personacard/personacard.component';
import {MatCardModule} from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddPersonaComponent } from './components/add-persona/add-persona.component';
import {MatIconModule} from '@angular/material/icon';
import {MatSliderModule} from '@angular/material/slider';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDialogModule} from '@angular/material/dialog';
import { PersonaFormComponent } from './components/persona-form/persona-form.component'

import { FormsModule,ReactiveFormsModule } from "@angular/forms"

import { HttpClientModule } from '@angular/common/http';
import { PersonaInfoComponent } from './components/persona-info/persona-info.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { DropUploadComponent } from './components/drop-upload/drop-upload.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonacardComponent,
    AddPersonaComponent,
    PersonaFormComponent,
    PersonaInfoComponent,
    ToolbarComponent,
    DropUploadComponent,
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
    FlexLayoutModule,
    MatToolbarModule,
    MatSliderModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [PersonaFormComponent]
  
})
export class AppModule { }
