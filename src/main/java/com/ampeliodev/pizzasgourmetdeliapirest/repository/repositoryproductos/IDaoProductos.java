package com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos.EntidadProductos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoProductos extends JpaRepository <EntidadProductos, Integer> {
    long count();
}
