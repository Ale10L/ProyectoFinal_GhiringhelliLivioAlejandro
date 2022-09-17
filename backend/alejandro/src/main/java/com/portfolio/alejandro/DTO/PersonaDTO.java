package com.portfolio.alejandro.DTO;

import javax.validation.constraints.NotBlank;

public class PersonaDTO {
    @NotBlank
    private String acerca_de;
    @NotBlank
    private String imagen_perfil;
    @NotBlank
    private String titulo;
    @NotBlank
    private String enlace_linkedin;
    @NotBlank
    private String enlace_github;
    @NotBlank
    private String enlace_instagram;
    @NotBlank
    private String enlace_whatsapp;

    public PersonaDTO() {
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
    
    
    
}
