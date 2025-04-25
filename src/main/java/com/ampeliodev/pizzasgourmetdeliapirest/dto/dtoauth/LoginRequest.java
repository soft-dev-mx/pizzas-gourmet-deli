package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth;

import lombok.Data;

@Data
public class LoginRequest {

    private String emailUsuario;
    private String passwordUsuario;

}
