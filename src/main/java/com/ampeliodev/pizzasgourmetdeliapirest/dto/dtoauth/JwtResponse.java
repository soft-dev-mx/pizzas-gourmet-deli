package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth;

import lombok.Data;


public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String emailUsuario;
    private String rolusuario;

    public JwtResponse(String token, String emailUsuario, String rolusuario) {
        this.token = token;
        this.emailUsuario = emailUsuario;
        this.rolusuario = rolusuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(String rolusuario) {
        this.rolusuario = rolusuario;
    }
}

