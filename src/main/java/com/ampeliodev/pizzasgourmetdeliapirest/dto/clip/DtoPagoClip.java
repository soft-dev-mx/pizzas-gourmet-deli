package com.ampeliodev.pizzasgourmetdeliapirest.dto.clip;

public class DtoPagoClip {

    double importeTotal;

    public DtoPagoClip() {
    }

    public DtoPagoClip(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

}
