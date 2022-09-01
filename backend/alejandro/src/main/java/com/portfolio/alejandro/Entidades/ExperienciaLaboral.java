package com.portfolio.alejandro.Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @NotNull
    @Size(min=1,max=300,message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String nombre;
    
    @NotNull
    @Size(min=1,max=300,message="Los datos ingresados no cumplen con la longitud de caracteres")
    private String descripcion;
    
    @NotNull
    private Date fecha_inicio;
    
    private Date fecha_fin;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        if(fecha_fin == null){
            this.fecha_fin = new Date();
        }
        this.fecha_fin = fecha_fin;
    }
    
    
}
