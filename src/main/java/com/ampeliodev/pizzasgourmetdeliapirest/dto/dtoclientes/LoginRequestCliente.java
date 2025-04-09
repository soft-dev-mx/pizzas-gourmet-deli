package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoclientes;

public class LoginRequestCliente {

    private String emailCliente;
    private String password;

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
