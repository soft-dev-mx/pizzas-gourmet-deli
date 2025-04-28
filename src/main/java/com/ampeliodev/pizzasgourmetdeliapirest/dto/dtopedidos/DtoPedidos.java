package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class DtoPedidos {

    private int idPedido;
    private LocalDateTime hrFechaPedido;
    private int idProductoPedido;
    private String nombreProductoPedido;
    private String tamanoProductoPedido;
    private double precioProductoPedido;
    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String telefonoCliente;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String delegacion;
    private String codigoPostal;

    public DtoPedidos() {
    }

    public DtoPedidos(int idPedido, LocalDateTime hrFechaPedido, int idProductoPedido, String nombreProductoPedido, String tamanoProductoPedido, double precioProductoPedido, int idCliente, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, String calle, String numeroExterior, String numeroInterior, String colonia, String delegacion, String codigoPostal) {
        this.idPedido = idPedido;
        this.hrFechaPedido = hrFechaPedido;
        this.idProductoPedido = idProductoPedido;
        this.nombreProductoPedido = nombreProductoPedido;
        this.tamanoProductoPedido = tamanoProductoPedido;
        this.precioProductoPedido = precioProductoPedido;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.codigoPostal = codigoPostal;
    }

    public DtoPedidos(int idProductoPedido, String nombreProductoPedido, String tamanoProductoPedido, double precioProductoPedido, int idCliente, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, String calle, String numeroExterior, String numeroInterior, String colonia, String delegacion, String codigoPostal) {
        this.idProductoPedido = idProductoPedido;
        this.nombreProductoPedido = nombreProductoPedido;
        this.tamanoProductoPedido = tamanoProductoPedido;
        this.precioProductoPedido = precioProductoPedido;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.codigoPostal = codigoPostal;
    }

    public int getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(int idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    public String getNombreProductoPedido() {
        return nombreProductoPedido;
    }

    public void setNombreProductoPedido(String nombreProductoPedido) {
        this.nombreProductoPedido = nombreProductoPedido;
    }

    public String getTamanoProductoPedido() {
        return tamanoProductoPedido;
    }

    public void setTamanoProductoPedido(String tamanoProductoPedido) {
        this.tamanoProductoPedido = tamanoProductoPedido;
    }

    public double getPrecioProductoPedido() {
        return precioProductoPedido;
    }

    public void setPrecioProductoPedido(double precioProductoPedido) {
        this.precioProductoPedido = precioProductoPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
