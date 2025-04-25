package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth;

import lombok.Data;

@Data
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String rolUsuario;

    public JwtResponse(String token, String username, String rol) {
        this.token = token;
        this.nombreUsuario = username;
        this.rolUsuario = rol;
    }
}

