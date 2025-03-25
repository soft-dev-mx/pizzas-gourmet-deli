package com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos;

import jakarta.persistence.Column;

public class DtoEntidadProductos {

    private int idProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private int claveProducto;
    private double precioProductoMini;
    private double precioProductoIndividual;
    private double precioProductoChica;
    private double precioProductoMediana;
    private double precioProductoGrande;
    private double precioProductoFamiliar;
    private double precioProductoOtros;
    private String descripcionProducto;
    private String imagenProducto;

    public DtoEntidadProductos() {
    }

    public DtoEntidadProductos(int idProducto, String nombreProducto, String categoriaProducto, int claveProducto, double precioProductoMini, double precioProductoIndividual, double precioProductoChica, double precioProductoMediana, double precioProductoGrande, double precioProductoFamiliar, double precioProductoOtros, String descripcionProducto, String imagenProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.claveProducto = claveProducto;
        this.precioProductoMini = precioProductoMini;
        this.precioProductoIndividual = precioProductoIndividual;
        this.precioProductoChica = precioProductoChica;
        this.precioProductoMediana = precioProductoMediana;
        this.precioProductoGrande = precioProductoGrande;
        this.precioProductoFamiliar = precioProductoFamiliar;
        this.precioProductoOtros = precioProductoOtros;
        this.descripcionProducto = descripcionProducto;
        this.imagenProducto = imagenProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public int getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(int claveProducto) {
        this.claveProducto = claveProducto;
    }

    public double getPrecioProductoMini() {
        return precioProductoMini;
    }

    public void setPrecioProductoMini(double precioProductoMini) {
        this.precioProductoMini = precioProductoMini;
    }

    public double getPrecioProductoIndividual() {
        return precioProductoIndividual;
    }

    public void setPrecioProductoIndividual(double precioProductoIndividual) {
        this.precioProductoIndividual = precioProductoIndividual;
    }

    public double getPrecioProductoChica() {
        return precioProductoChica;
    }

    public void setPrecioProductoChica(double precioProductoChica) {
        this.precioProductoChica = precioProductoChica;
    }

    public double getPrecioProductoMediana() {
        return precioProductoMediana;
    }

    public void setPrecioProductoMediana(double precioProductoMediana) {
        this.precioProductoMediana = precioProductoMediana;
    }

    public double getPrecioProductoGrande() {
        return precioProductoGrande;
    }

    public void setPrecioProductoGrande(double precioProductoGrande) {
        this.precioProductoGrande = precioProductoGrande;
    }

    public double getPrecioProductoFamiliar() {
        return precioProductoFamiliar;
    }

    public void setPrecioProductoFamiliar(double precioProductoFamiliar) {
        this.precioProductoFamiliar = precioProductoFamiliar;
    }

    public double getPrecioProductoOtros() {
        return precioProductoOtros;
    }

    public void setPrecioProductoOtros(double precioProductoOtros) {
        this.precioProductoOtros = precioProductoOtros;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
}
