package com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="productos_gourmet_deli")
public class EntidadProductos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private int idProducto;
    @Column(name="nombre_producto")
    private String nombreProducto;
    @Column(name="categoria_producto")
    private String categoriaProducto;
    @Column(name="clave_producto")
    private int claveProducto;
    @Column(name="precio_producto_mini")
    private double precioProductoMini;
    @Column(name="precio_producto_individual")
    private double precioProductoIndividual;
    @Column(name="precio_producto_chica")
    private double precioProductoChica;
    @Column(name="precio_producto_mediana")
    private double precioProductoMediana;
    @Column(name="precio_producto_grande")
    private double precioProductoGrande;
    @Column(name="precio_producto_familiar")
    private double precioProductoFamiliar;
    @Column(name="precio_producto_otros")
    private double precioProductoOtros;
    @Column(name="descripcion_producto")
    private String descripcionProducto;
    @Column(name="imagen_producto")
    private String imagenProducto;

}
