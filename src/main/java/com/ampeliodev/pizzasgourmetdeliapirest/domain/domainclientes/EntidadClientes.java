package com.ampeliodev.pizzasgourmetdeliapirest.domain.domainclientes;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="clientes")
public class EntidadClientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int idCliente;
    @Column(name="nombre_cliente")
    private String nombreCliente;
    @Column(name="apellido_cliente")
    private String apellidoCliente;
    @Column(name="email_cliente")
    private String emailCliente;
    @Column(name="password_cliente")
    private String passwordCliente;
    @Column(name="telefono_cliente")
    private int telefonoCliente;

}
