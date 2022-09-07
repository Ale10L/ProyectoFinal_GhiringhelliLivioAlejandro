import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experiencia_Laboral } from '../model/experiencia_laboral.model';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaLaboralService {
  //URL = 'http://localhost:8080/personas/experiencia-laboral/'
  URL = 'http://localhost:8080/explab/'
  constructor(private http: HttpClient) { }

  public getExperienciaLaboral(): Observable<Experiencia_Laboral[]>{
    return this.http.get<Experiencia_Laboral[]>(this.URL+'traer');
  }

  public detail(id: number): Observable<Experiencia_Laboral>{
    return this.http.get<Experiencia_Laboral>(this.URL +`personas/experiencia-laboral/detail/${id}`);
  }

  public alta(experiencia: Experiencia_Laboral): Observable<Object>{
    return this.http.post<any>(this.URL+`crear`, experiencia);
  }

  public modificar(id: number, experiencia: Experiencia_Laboral): Observable<Object>{
    return this.http.put<any>(this.URL+`personas/experiencia-laboral/modificar/${id}`, experiencia);
  }

  public baja(id: number, experiencia: Experiencia_Laboral): Observable<Object>{
    return this.http.delete<any>(this.URL+`personas/experiencia-laboral/borrar/${id}`);
  }
}
