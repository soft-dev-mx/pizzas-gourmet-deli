package com.ampeliodev.pizzasgourmetdeliapirest.service.servicepedidos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainpedidos.EntidadPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos.DtoPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositorypedidos.IDaoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePedidosImplements implements IServicePedidos{

    @Autowired
    private IDaoPedidos iDaoPedidos;

    @Override
    @Transactional
    public DtoPedidos guardarPedidos(DtoPedidos pedidos) {

      EntidadPedidos entidadPedidos = new EntidadPedidos();

      entidadPedidos.setHrFechaPedido(LocalDateTime.now());
      entidadPedidos.setIdProductoPedido(pedidos.getIdProductoPedido());
      entidadPedidos.setNombreProductoPedido(pedidos.getNombreProductoPedido());
      entidadPedidos.setTamanoProductoPedido(pedidos.getTamanoProductoPedido());
      entidadPedidos.setPrecioProductoPedido(pedidos.getPrecioProductoPedido());

      entidadPedidos.setIdCliente(pedidos.getIdCliente());
      entidadPedidos.setNombreCliente(pedidos.getNombreCliente());
      entidadPedidos.setApellidoCliente(pedidos.getApellidoCliente());
      entidadPedidos.setEmailCliente(pedidos.getEmailCliente());
      entidadPedidos.setTelefonoCliente(pedidos.getTelefonoCliente());

      entidadPedidos.setCalle(pedidos.getCalle());
      entidadPedidos.setNumeroExterior(pedidos.getNumeroExterior());
      entidadPedidos.setNumeroInterior(pedidos.getNumeroInterior());
      entidadPedidos.setColonia(pedidos.getColonia());
      entidadPedidos.setDelegacion(pedidos.getDelegacion());
      entidadPedidos.setCodigoPostal(pedidos.getCodigoPostal());

       iDaoPedidos.save(entidadPedidos);

       return pedidos;
    }


}
