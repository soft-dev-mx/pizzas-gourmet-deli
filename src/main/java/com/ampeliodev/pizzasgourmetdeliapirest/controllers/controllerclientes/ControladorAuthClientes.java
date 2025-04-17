package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerclientes;

import com.ampeliodev.pizzasgourmetdeliapirest.config.configauth.authcliente.JwtClientProvider;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.JwtResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoclientes.LoginRequestCliente;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoclientes.ClientesRegisterRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoserverresponse.DtoServerResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainclientes.EntidadClientes;
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
    private AuthenticationManager authenticationClientManager;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private PasswordEncoder clientPasswordEncoder;

    @Autowired
    private JwtClientProvider jwtClientProvider;

    @PostMapping("/cliente-login")
    public ResponseEntity<?> login(@RequestBody LoginRequestCliente loginRequest) {
        Authentication authentication = authenticationClientManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmailCliente(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtClientProvider.generateToken(authentication);
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
        usuario.setPasswordCliente(clientPasswordEncoder.encode(signUpRequest.getPasswordCliente()));
        usuario.setTelefonoCliente(signUpRequest.getTelefonoCliente());
        clientesRepository.save(usuario);

        return ResponseEntity.ok( new DtoServerResponse("Usuario registrado correctamente"));
    }

}
