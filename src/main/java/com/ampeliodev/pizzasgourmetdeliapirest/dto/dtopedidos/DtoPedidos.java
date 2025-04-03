package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class DtoPedidos {

    private int idPedido;
    private String formaEntregaPedido;
    private LocalDateTime hrFechaProducto;
    private int idProductoPedido;
    private String nombreProductoPedido;
    private String tamanoProductoPedido;
    private int idCliente;

    public DtoPedidos() {
    }

    public DtoPedidos(int idPedido, String formaEntregaPedido, LocalDateTime hrFechaProducto, int idProductoPedido, String nombreProductoPedido, String tamanoProductoPedido, int idCliente) {
        this.idPedido = idPedido;
        this.formaEntregaPedido = formaEntregaPedido;
        this.hrFechaProducto = hrFechaProducto;
        this.idProductoPedido = idProductoPedido;
        this.nombreProductoPedido = nombreProductoPedido;
        this.tamanoProductoPedido = tamanoProductoPedido;
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFormaEntregaPedido() {
        return formaEntregaPedido;
    }

    public void setFormaEntregaPedido(String formaEntregaPedido) {
        this.formaEntregaPedido = formaEntregaPedido;
    }

    public LocalDateTime getHrFechaProducto() {
        return hrFechaProducto;
    }

    public void setHrFechaProducto(LocalDateTime hrFechaProducto) {
        this.hrFechaProducto = hrFechaProducto;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
