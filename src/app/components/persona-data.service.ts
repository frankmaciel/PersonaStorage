import { Injectable } from '@angular/core';
import { Persona } from './persona';
import { catchError, retry} from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { personaInterface } from './persona-interface';
import { map } from 'rxjs/operators';

interface saveResponse{
  response: string
}

@Injectable({
  providedIn: 'root'
})
export class PersonaDataService {

  constructor(private http: HttpClient) { 
  }
  private personas_data = new BehaviorSubject<Observable<personaInterface>>(this.getPersonasData())
  personas = this.personas_data.asObservable()

  savePersonaData(persona: Persona){
    var jsonPersona = JSON.stringify(persona)
    this.http.post<saveResponse>("http://localhost:8080/api/addpersona", jsonPersona).subscribe()
  }

  editPersonaData(persona: Persona){
    var jsonPersona = JSON.stringify(persona)
    this.http.post<saveResponse>("http://localhost:8080/api/editpersona", jsonPersona).subscribe()
  }

  getPersonasData(){ 
    let temp = this.http.get<personaInterface>("http://localhost:8080/api/getpersonas").pipe(retry(3))
    return temp
  }


  refreshPersonaData(){
    this.personas_data.next(this.getPersonasData())
  }

}

