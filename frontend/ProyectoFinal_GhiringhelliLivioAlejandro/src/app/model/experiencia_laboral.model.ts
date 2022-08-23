export class Experiencia_Laboral{
  id?: number;
  nombre: String;
  descripcion: String;
  fecha_inicio: String;
  fecha_fin: String;


  constructor(nombre: String,descripcion: String, fecha_inicio: String, fecha_fin: String){
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.fecha_inicio = fecha_inicio;
      this.fecha_fin = fecha_fin;
    }
}
