package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoclientes;

public class ClientesLoginRequest {

    private String emailCliente;
    private String passwordCliente;

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }
}
