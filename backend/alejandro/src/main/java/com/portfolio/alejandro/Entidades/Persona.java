package com.portfolio.alejandro.Entidades;

//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1,max=50, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String apellido;
    @NotNull
    @Size(min=1,max=50, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String nombre;
    
    private Date fecha_nac;
    
    
    @Size(min=1, max=3000,message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String acerca_de;
    
    @NotNull
    private String imagen_perfil;
    
    @NotNull
    @Size(min=1,max=50, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String localidad;
    @NotNull
    @Size(min=1,max=50, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String email;
    @NotNull
    @Size(min=1,max=50, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String titulo;
    
    private String enlace_linkedin;
    private String enlace_github;
    private String enlace_instagram;
    private String enlace_whatsapp;
    
    /*private ExperienciaLaboral MiExperienciaLaboral;
    private Educacion MiEducacion;
    private Skills MiSkill;
    private Proyectos MiProyecto;
    
    private List<ExperienciaLaboral> ListaDeTrabajos = new ArrayList<ExperienciaLaboral>();
    private List<Educacion> ListaEducacion = new ArrayList<Educacion>();
    private List<Skills> ListaDeSkills = new ArrayList<Skills>();
    private List<Proyectos> ListaDeProyectos = new ArrayList<Proyectos>();*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnlace_linkedin() {
        return enlace_linkedin;
    }

    public void setEnlace_linkedin(String enlace_linkedin) {
        this.enlace_linkedin = enlace_linkedin;
    }

    public String getEnlace_github() {
        return enlace_github;
    }

    public void setEnlace_github(String enlace_github) {
        this.enlace_github = enlace_github;
    }

    public String getEnlace_instagram() {
        return enlace_instagram;
    }

    public void setEnlace_instagram(String enlace_instagram) {
        this.enlace_instagram = enlace_instagram;
    }

    public String getEnlace_whatsapp() {
        return enlace_whatsapp;
    }

    public void setEnlace_whatsapp(String enlace_whatsapp) {
        this.enlace_whatsapp = enlace_whatsapp;
    }

    /*public ExperienciaLaboral getMiExperienciaLaboral() {
        return MiExperienciaLaboral;
    }

    public void setMiExperienciaLaboral(ExperienciaLaboral MiExperienciaLaboral) {
        this.MiExperienciaLaboral = MiExperienciaLaboral;
    }

    public Educacion getMiEducacion() {
        return MiEducacion;
    }

    public void setMiEducacion(Educacion MiEducacion) {
        this.MiEducacion = MiEducacion;
    }

    public Skills getMiSkill() {
        return MiSkill;
    }

    public void setMiSkill(Skills MiSkill) {
        this.MiSkill = MiSkill;
    }

    public Proyectos getMiProyecto() {
        return MiProyecto;
    }

    public void setMiProyecto(Proyectos MiProyecto) {
        this.MiProyecto = MiProyecto;
    }

    public List<ExperienciaLaboral> getListaDeTrabajos() {
        return ListaDeTrabajos;
    }

    public void setListaDeTrabajos(List<ExperienciaLaboral> ListaDeTrabajos) {
        this.ListaDeTrabajos = ListaDeTrabajos;
    }

    public List<Educacion> getListaEducacion() {
        return ListaEducacion;
    }

    public void setListaEducacion(List<Educacion> ListaEducacion) {
        this.ListaEducacion = ListaEducacion;
    }

    public List<Skills> getListaDeSkills() {
        return ListaDeSkills;
    }

    public void setListaDeSkills(List<Skills> ListaDeSkills) {
        this.ListaDeSkills = ListaDeSkills;
    }

    public List<Proyectos> getListaDeProyectos() {
        return ListaDeProyectos;
    }

    public void setListaDeProyectos(List<Proyectos> ListaDeProyectos) {
        this.ListaDeProyectos = ListaDeProyectos;
    }*/
    
    
    
}