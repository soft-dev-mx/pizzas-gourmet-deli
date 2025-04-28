package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth;

import lombok.Data;


public class LoginRequest {

    private String emailUsuario;
    private String passwordUsuario;

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
}
