package com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryauth;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.EntidadUsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<EntidadUsuarioAuth, Long> {

    Optional<EntidadUsuarioAuth> findByEmailUsuario(String emailUsuario);
    boolean existsByEmailUsuario(String email);

}
