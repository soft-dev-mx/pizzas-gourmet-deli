package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerauth;

import com.ampeliodev.pizzasgourmetdeliapirest.config.configauth.auth.JwtProvider;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.JwtResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.LoginRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.RegisterRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoserverresponse.DtoServerResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.EntidadUsuarioAuth;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryauth.UsuarioRepository;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceauth.ServiceSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "https://soft-dev-mx.com")
@Slf4j
public class ControladorAuth {

    @Autowired
    private ServiceSecurity serviceSecurity;

    @Autowired
    private JwtProvider jwtProvider;

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
        return serviceSecurity.login(loginRequest
        );
    }

}






