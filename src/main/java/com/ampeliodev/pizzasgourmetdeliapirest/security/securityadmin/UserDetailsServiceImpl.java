package com.ampeliodev.pizzasgourmetdeliapirest.security.securityadmin;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.EntidadUsuarioAuth;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryauth.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntidadUsuarioAuth usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new UserDetailsImpl(usuario);
    }
}
