package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerauth;

import com.ampeliodev.pizzasgourmetdeliapirest.config.configauth.authusuario.JwtProvider;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.JwtResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.LoginRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.RegisterRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoserverresponse.DtoServerResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.EntidadUsuarioAuth;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryauth.UsuarioRepository;
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
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://soft-dev-mx.com")
@Slf4j
public class ControladorAuth {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest signUpRequest) {
        if (usuarioRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: ¡Usuario ya existe!");
        }
        if (usuarioRepo.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: ¡Email ya existe!");
        }

        EntidadUsuarioAuth usuario = new EntidadUsuarioAuth();
        usuario.setUsername(signUpRequest.getUsername());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        usuarioRepo.save(usuario);

        return ResponseEntity.ok( new DtoServerResponse("Usuario registrado correctamente"));
    }

}






