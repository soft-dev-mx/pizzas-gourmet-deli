package com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryclientes;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainclientes.EntidadClientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository <EntidadClientes,Integer> {

    Optional<EntidadClientes> findBynombreCliente(String nombreCliente);
    boolean existsBynombreCliente(String nombreCliente);
    boolean existsByemailCliente(String emailCliente);
}
