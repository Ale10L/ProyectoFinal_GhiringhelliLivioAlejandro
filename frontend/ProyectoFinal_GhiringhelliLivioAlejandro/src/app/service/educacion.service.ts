import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion.model';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  URL = 'http://localhost:8080/personas/educacion/'
  constructor(private http: HttpClient) { }

  public getEducacion(): Observable<Educacion>{
    return this.http.get<Educacion>(this.URL+'traer');
  }
}
