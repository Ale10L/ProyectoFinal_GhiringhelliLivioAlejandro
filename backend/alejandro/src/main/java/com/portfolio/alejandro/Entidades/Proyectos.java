package com.portfolio.alejandro.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1,max=50, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String nombre;
    @NotNull
    @Size(min=1,max=300, message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String descripcion;
    @NotNull
    private String enlace_proyecto;

    public Proyectos(){
        
    }

    public Proyectos(String nombre, String descripcion, String enlace_proyecto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace_proyecto = enlace_proyecto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace_proyecto() {
        return enlace_proyecto;
    }

    public void setEnlace_proyecto(String enlace_proyecto) {
        this.enlace_proyecto = enlace_proyecto;
    }
}
