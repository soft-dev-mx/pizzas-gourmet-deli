package com.ampeliodev.pizzasgourmetdeliapirest.service.servicepedidos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainpedidos.EntidadPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos.DtoPedidos;

import java.util.List;

public interface IServicePedidos {

    public List<DtoPedidos> listarPedidos();

    public void guardarPedidos(List<DtoPedidos> pedidos);

}
