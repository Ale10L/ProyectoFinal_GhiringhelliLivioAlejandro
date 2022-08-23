export class Persona{
  id?: number;
  apellido: String;
  nombre: String;
  acerca_de: String;
  fecha_nac: String;
  imagen_perfil: String;
  localidad: String;
  email: String;
  titulo: String;
  enlace_linkedin: String;
  enlace_github: String;
  enlace_instagram: String;
  enlace_whatsapp: String;

  constructor(apellido: String, nombre: String, acerca_de: String, fecha_nac: String, imagen_perfil: String,
    localidad: String, email: String, titulo: String, enlace_linkedin: String, enlace_github: String,
    enlace_instagram: String, enlace_whatsapp: String){
      this.apellido = apellido;
      this.nombre = nombre;
      this.acerca_de = acerca_de;
      this.fecha_nac = fecha_nac;
      this.imagen_perfil = imagen_perfil;
      this.localidad = localidad;
      this.email = email;
      this.titulo = titulo;
      this.enlace_linkedin = enlace_linkedin;
      this.enlace_github = enlace_github;
      this.enlace_instagram = enlace_instagram;
      this.enlace_whatsapp = enlace_whatsapp;
    }
}
