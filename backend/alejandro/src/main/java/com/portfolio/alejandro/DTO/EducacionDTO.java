package com.portfolio.alejandro.DTO;

import java.util.Date;
import javax.validation.constraints.NotBlank;

public class EducacionDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String lugar;
    @NotBlank
    private Date fecha_inicio;
    private Date fecha_fin;

    public EducacionDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
        this.fecha_fin = fecha_fin;
    }
    
    
}
