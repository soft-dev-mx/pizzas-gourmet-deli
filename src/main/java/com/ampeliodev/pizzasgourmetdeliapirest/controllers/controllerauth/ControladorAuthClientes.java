package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerauth;

import com.ampeliodev.pizzasgourmetdeliapirest.config.configauth.JwtProvider;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.JwtResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.LoginRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainclientes.EntidadClientes;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoclientes.ClientesRegisterRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoserverresponse.DtoServerResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryclientes.ClientesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://soft-dev-mx.com")
@Slf4j
public class ControladorAuthClientes {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/cliente-login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registrar-cliente")
    public ResponseEntity<?> register(@RequestBody ClientesRegisterRequest signUpRequest) {
        if (clientesRepository.existsBynombreCliente(signUpRequest.getNombreCliente())) {
            return ResponseEntity.badRequest().body("Error: ¡Usuario ya existe!");
        }
        if (clientesRepository.existsByemailCliente(signUpRequest.getEmailCliente())) {
            return ResponseEntity.badRequest().body("Error: ¡Email ya existe!");
        }

        EntidadClientes usuario = new EntidadClientes();
        usuario.setNombreCliente(signUpRequest.getNombreCliente());
        usuario.setApellidoCliente(signUpRequest.getApellidoCliente());
        usuario.setEmailCliente(signUpRequest.getEmailCliente());
        usuario.setPasswordCliente(signUpRequest.getPasswordCliente());
        usuario.setTelefonoCliente(signUpRequest.getTelefonoCliente());
        clientesRepository.save(usuario);

        return ResponseEntity.ok( new DtoServerResponse("Usuario registrado correctamente"));
    }

}
