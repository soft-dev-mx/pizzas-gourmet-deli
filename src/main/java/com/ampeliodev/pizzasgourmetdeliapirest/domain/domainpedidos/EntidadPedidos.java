package com.ampeliodev.pizzasgourmetdeliapirest.domain.domainpedidos;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="pedidos")
public class EntidadPedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private int idPedido;
    @Column(name="forma_entrega_pedido")
    private String formaEntregaPedido;
    @Column(name="hr_fecha_producto")
    private LocalDateTime hrFechaProducto;
    @Column(name="id_producto_pedido")
    private int idProductoPedido;
    @Column(name="nombre_producto_pedido")
    private String nombreProductoPedido;
    @Column(name="tamano_producto_pedido")
    private String tamanoProductoPedido;
    @Column(name="id_cliente")
    private int idCliente;

}
