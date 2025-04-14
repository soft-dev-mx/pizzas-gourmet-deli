package com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos.EntidadProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDaoProductos extends JpaRepository <EntidadProductos, Integer> {

    long count();

    @Query(value = "SELECT * FROM productos_gourmet_deli WHERE categoria_producto = :categoria1", nativeQuery = true)
    List<EntidadProductos> listarPorUnaCategoria(@Param("categoria1") String categoria1);

    @Query(value = "SELECT * FROM productos_gourmet_deli WHERE categoria_producto = :categoria1 OR categoria_producto = :categoria2", nativeQuery = true)
    List<EntidadProductos> listarPorCategoria(@Param("categoria1") String categoria1, @Param("categoria2") String categoria2);
}
