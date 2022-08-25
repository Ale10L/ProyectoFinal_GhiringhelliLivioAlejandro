package com.portfolio.alejandro.Security.DTO;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String contrasenia;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
