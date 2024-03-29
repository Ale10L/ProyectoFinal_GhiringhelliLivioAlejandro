import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'https://back-ghiringhelli-alejandro.onrender.com/personas/'
  //URL = 'https://bkdghiringhellialejandro.herokuapp.com/personas/'
  //URL = 'https://localhost:8080/explab/'

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<Persona>{
    return this.http.get<Persona>(this.URL+'traer-perfil');
  }
}
