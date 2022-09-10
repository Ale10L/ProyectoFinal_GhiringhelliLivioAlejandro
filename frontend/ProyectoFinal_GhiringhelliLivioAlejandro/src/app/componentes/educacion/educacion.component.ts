import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion.model';
import { EducacionService } from 'src/app/service/educacion.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  educacion: Educacion[] = [];

  constructor(public educacionService: EducacionService, private tokenService: TokenService, private router: Router) { }
  isLoged = false;

  ngOnInit(): void {
    this.cargarEducacion();
    if(this.tokenService.getToken()){
      this.isLoged = true;
    } else {
      this.isLoged = false;
    }
  }

  cargarEducacion(): void{
    this.educacionService.getEducacion().subscribe(data => {this.educacion = data});
  }

  getYearInicio(fecha: string): number {
    let devolverFecha: number;
    devolverFecha = new Date(fecha).getFullYear();
    return devolverFecha;
  }

  getYearFin(fecha: string): any {
    let devolverFecha: any;
    if(fecha !== null){
      devolverFecha = new Date(fecha).getFullYear();
    } else {
      devolverFecha = "actualidad";
    }
    return devolverFecha;
  }

  onSubmit(){
    this.cargarEducacion();
  }

  eliminar(id?: number){
    if(id != undefined){
      this.educacionService.baja(id).subscribe({
        next:
            data => {
              alert("Educación eliminada exitosamente");
              this.cargarEducacion();
              this.router.navigate(['']);
            },
          error: error => {
            alert("No se pudo eliminar la Educación");
            this.router.navigate(['']);
          }
        }
      );
    }
  }
}
