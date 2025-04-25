package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.RolName;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class RegisterRequest {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private Long telefonoUsuario;
    private String rolUsuario;

}
