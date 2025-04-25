package com.ampeliodev.pizzasgourmetdeliapirest.security.securityauth;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainauth.EntidadUsuarioAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private String emailUsuario;
    private String passwordUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String emailUsuario, String passwordUsuario,
                           Collection<? extends GrantedAuthority> authorities) {
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(EntidadUsuarioAuth entidadUsuarioAuth) {
        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(entidadUsuarioAuth.getRolUsuario().name())
        );

        return new UserDetailsImpl(
                entidadUsuarioAuth.getEmailUsuario(),
                entidadUsuarioAuth.getPasswordUsuario(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwordUsuario;
    }

    @Override
    public String getUsername() {
        return emailUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
