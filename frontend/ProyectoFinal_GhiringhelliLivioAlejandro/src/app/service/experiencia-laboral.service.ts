import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experiencia_Laboral } from '../model/experiencia_laboral.model';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaLaboralService {
  URL = 'http://localhost:8080/personas/experiencia-laboral/'
  constructor(private http: HttpClient) { }

  public getExperienciaLaboral(): Observable<Experiencia_Laboral>{
    return this.http.get<Experiencia_Laboral>(this.URL+'traer');
  }
}
