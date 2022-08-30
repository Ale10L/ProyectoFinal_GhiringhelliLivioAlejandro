import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  educacion: any;
  constructor(public educacionService: EducacionService) { }

  ngOnInit(): void {
    this.educacionService.getEducacion().subscribe(data => {this.educacion = data});
  }

  getYearInicio(fecha: number): number {
    let devolverFecha: number;
    devolverFecha = new Date(fecha).getFullYear();
    return devolverFecha;
  }

  getYearFin(fecha: number): any {
    let devolverFecha: any;
    if(fecha !== null){
      devolverFecha = new Date(fecha).getFullYear();
    } else {
      devolverFecha = "actualidad";
    }
    return devolverFecha;
  }
}
