import { Component, OnInit } from '@angular/core';
import { Experiencia_Laboral } from 'src/app/model/experiencia_laboral.model';
import { ExperienciaLaboralService } from 'src/app/service/experiencia-laboral.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  experiencia: Experiencia_Laboral[] = [];

  constructor(private experienciaService: ExperienciaLaboralService, private tokenService: TokenService) { }

  isLoged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if(this.tokenService.getToken()){
      this.isLoged = true;
    } else {
      this.isLoged = false;
    }
  }

  cargarExperiencia(): void{
    this.experienciaService.getExperienciaLaboral().subscribe(data => {this.experiencia = data;});
  }

  getYearInicio(fecha: string): number {
    let devolverFecha: number;
    devolverFecha = new Date(fecha).getFullYear();
    return devolverFecha;
  }

  getYearFin(fecha: string): any {
    let devolverFecha: any;
    if (fecha !== null) {
      devolverFecha = new Date(fecha).getFullYear();
    } else {
      devolverFecha = "actualidad";
    }
    return devolverFecha;
  }

  onSubmit(){
    this.cargarExperiencia();
  }

}
