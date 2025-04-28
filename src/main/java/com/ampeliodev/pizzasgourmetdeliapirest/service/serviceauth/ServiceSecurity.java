package com.ampeliodev.pizzasgourmetdeliapirest.service.serviceauth;

import com.ampeliodev.pizzasgourmetdeliapirest.config.configauth.auth.JwtProvider;
import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.EntidadUsuarioAuth;
import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.RolName;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.JwtResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.LoginRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.RegisterRequest;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryauth.UsuarioRepository;
import com.ampeliodev.pizzasgourmetdeliapirest.security.securityauth.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceSecurity {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public ResponseEntity<?> registraUsuario(RegisterRequest registerRequest) {

        if (userRepository.existsByEmailUsuario(registerRequest.getEmailUsuario())) {
            return ResponseEntity.badRequest().body("Error: Este email ya se encuentra registrado");
        }

        EntidadUsuarioAuth usuario = new EntidadUsuarioAuth();
        usuario.setNombreUsuario(registerRequest.getNombreUsuario());
        usuario.setApellidoUsuario(registerRequest.getApellidoUsuario());
        usuario.setEmailUsuario(registerRequest.getEmailUsuario());
        usuario.setPasswordUsuario(passwordEncoder.encode(registerRequest.getPasswordUsuario()));
        usuario.setTelefonoUsuario(registerRequest.getTelefonoUsuario());

        try {
            RolName rol = RolName.valueOf(registerRequest.getRolusuario());
            usuario.setRolusuario(rol);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: Rol inválido");
        }

        userRepository.save(usuario);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente");

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<JwtResponse> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmailUsuario(),
                        loginRequest.getPasswordUsuario()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String rol = userDetails.getAuthorities().iterator().next().getAuthority();

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getUsername(),
                rol
        ));
    }
}
