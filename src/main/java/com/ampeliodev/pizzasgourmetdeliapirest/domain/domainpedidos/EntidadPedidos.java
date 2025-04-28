package com.ampeliodev.pizzasgourmetdeliapirest.domain.domainpedidos;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="pedidos")
public class EntidadPedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private int idPedido;
    @Column(name="hr_fecha_pedido")
    private LocalDateTime hrFechaPedido;

    @Column(name="id_producto_pedido")
    private int idProductoPedido;
    @Column(name="nombre_producto_pedido")
    private String nombreProductoPedido;
    @Column(name="tamano_producto_pedido")
    private String tamanoProductoPedido;
    @Column(name="precio_producto_pedido")
    private double precioProductoPedido;

    @Column(name="id_cliente")
    private int idCliente;
    @Column(name="nombre_cliente")
    private String nombreCliente;
    @Column(name="apellido_cliente")
    private String apellidoCliente;
    @Column(name="email_cliente")
    private String emailCliente;
    @Column(name="telefono_cliente")
    private String telefonoCliente;

    @Column(name="calle")
    private String calle;
    @Column(name="numero_exterior")
    private String numeroExterior;
    @Column(name="numero_interior")
    private String numeroInterior;
    @Column(name="colonia")
    private String colonia;
    @Column(name="delegacion")
    private String delegacion;
    @Column(name="codigo_postal")
    private String codigoPostal;

}
