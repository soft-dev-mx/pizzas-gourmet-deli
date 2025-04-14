package com.ampeliodev.pizzasgourmetdeliapirest.security.securitycliente;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainclientes.EntidadClientes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClientDetailsImpl implements UserDetails {

    private String emailCliente;
    private String passwordCliente;

    public ClientDetailsImpl(EntidadClientes entidadClientes) {
        this.emailCliente = entidadClientes.getEmailCliente();
        this.passwordCliente = entidadClientes.getPasswordCliente();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return passwordCliente;
    }

    @Override
    public String getUsername() {
        return emailCliente;
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
