package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.RolName;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


public class RegisterRequest {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private Long telefonoUsuario;
    private String rolusuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Long getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(Long telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(String rolusuario) {
        this.rolusuario = rolusuario;
    }
}
