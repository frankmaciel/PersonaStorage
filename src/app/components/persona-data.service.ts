import { Injectable } from '@angular/core';
import { Persona } from './persona';
import { catchError, retry} from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { personaInterface } from './persona-interface';

@Injectable({
  providedIn: 'root'
})
export class PersonaDataService {

  constructor(private http: HttpClient) { }

  private personas_data = new BehaviorSubject<Observable<personaInterface>>(this.getPersonasData())
  personas = this.personas_data.asObservable()

  savePersonaData(persona: Persona){
    var jsonPersona = JSON.stringify(persona)
  }

  getPersonasData(){ // used for the variable above
    let temp = this.http.get<personaInterface>("localhost:8080/api/getpersonas").pipe(retry(3))
    return temp
  }

  refreshPersonasData(){ // used to refresh the personas variable
    this.personas_data.next(this.getPersonasData())
  }


}

