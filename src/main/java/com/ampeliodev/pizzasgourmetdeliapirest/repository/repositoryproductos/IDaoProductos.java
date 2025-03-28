package com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos.EntidadProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDaoProductos extends JpaRepository <EntidadProductos, Integer> {

    long count();

    @Query(value = "SELECT * FROM productos_gourmet_deli WHERE categoria_producto = :categoria", nativeQuery = true)
    List<EntidadProductos> listarPorCategoria(@Param("categoria") String categoria);
}
