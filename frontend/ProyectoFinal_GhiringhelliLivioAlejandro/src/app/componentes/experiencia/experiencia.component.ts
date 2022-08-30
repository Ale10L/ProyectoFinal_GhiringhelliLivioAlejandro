import { Component, OnInit } from '@angular/core';
import { Experiencia_Laboral } from 'src/app/model/experiencia_laboral.model';
import { ExperienciaLaboralService } from 'src/app/service/experiencia-laboral.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  experiencia: any;
  constructor(public experienciaService: ExperienciaLaboralService) { }

  ngOnInit(): void {
    this.experienciaService.getExperienciaLaboral().subscribe(data => { this.experiencia = data });
  }

  getYearInicio(fecha: number): number {
    let devolverFecha: number;
    devolverFecha = new Date(fecha).getFullYear();
    return devolverFecha;
  }

  getYearFin(fecha: number): any {
    let devolverFecha: any;
    if (fecha !== null) {
      devolverFecha = new Date(fecha).getFullYear();
    } else {
      devolverFecha = "actualidad";
    }
    return devolverFecha;
  }

}
