package com.ampeliodev.pizzasgourmetdeliapirest.repository.repositorypedidos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainpedidos.EntidadPedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoPedidos extends JpaRepository <EntidadPedidos,Integer> {

}
