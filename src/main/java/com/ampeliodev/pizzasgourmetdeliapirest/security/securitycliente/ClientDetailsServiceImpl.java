package com.ampeliodev.pizzasgourmetdeliapirest.security.securitycliente;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainclientes.EntidadClientes;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryclientes.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreCliente) throws UsernameNotFoundException {

        EntidadClientes entidadCliente = clientesRepository.findBynombreCliente(nombreCliente)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new ClientDetailsImpl(entidadCliente);
    }
}
