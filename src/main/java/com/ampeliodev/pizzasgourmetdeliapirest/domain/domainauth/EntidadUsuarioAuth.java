package com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class EntidadUsuarioAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    @Column(name="nombre_usuario")
    private String nombreUsuario;
    @Column(name="apellido_usuario")
    private String apellidoUsuario;
    @Column(name="email_usuario")
    private String emailUsuario;
    @Column(name="password_usuario")
    private String passwordUsuario;
    @Column(name="telefonoUsuario")
    private Long telefonoUsuario;

    @Enumerated(EnumType.STRING)
    private RolName rolUsuario;

}
