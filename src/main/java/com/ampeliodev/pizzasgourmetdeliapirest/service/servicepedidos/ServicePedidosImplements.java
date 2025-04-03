package com.ampeliodev.pizzasgourmetdeliapirest.service.servicepedidos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainpedidos.EntidadPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos.DtoPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositorypedidos.IDaoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePedidosImplements implements IServicePedidos{

    @Autowired
    private IDaoPedidos daoPedido;

    @Override
    public List<DtoPedidos> listarPedidos() {
        return List.of();
    }

    @Override
    @Transactional
    public void guardarPedidos(List<DtoPedidos> pedidos) {

        for(DtoPedidos pedido : pedidos){
            EntidadPedidos entidadPedidos = new EntidadPedidos();
            entidadPedidos.setFormaEntregaPedido(pedido.getFormaEntregaPedido());
            entidadPedidos.setHrFechaProducto(pedido.getHrFechaProducto());
            entidadPedidos.setIdProductoPedido(pedido.getIdProductoPedido());
            entidadPedidos.setNombreProductoPedido(pedido.getNombreProductoPedido());
            entidadPedidos.setTamanoProductoPedido(pedido.getTamanoProductoPedido());
            entidadPedidos.setIdPedido(pedido.getIdPedido());
            daoPedido.save(entidadPedidos);
        }
    }
}
