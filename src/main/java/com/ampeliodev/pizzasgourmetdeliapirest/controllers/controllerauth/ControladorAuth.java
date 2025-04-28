package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerauth;


import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.*;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos.DtoPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceauth.ServiceSecurity;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceclip.ServicioPagoClip;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceproductos.IServiceProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ControladorAuth {

    @Autowired
    private ServiceSecurity serviceSecurity;


    @Autowired
    private IServiceProductos interfazServicioProductos;

    @PostMapping("/adminsignin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest registerRequest) {
        return serviceSecurity.registraUsuario(registerRequest);
    }

    @PostMapping("/clientesignin")
    public ResponseEntity<?> registerCliente(@RequestBody RegisterRequest registerRequest) {
        return serviceSecurity.registraUsuario(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        return serviceSecurity.login(loginRequest);
    }

}






