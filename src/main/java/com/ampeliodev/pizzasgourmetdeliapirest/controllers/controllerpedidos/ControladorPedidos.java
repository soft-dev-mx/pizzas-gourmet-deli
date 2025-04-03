package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerpedidos;

import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos.DtoPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.service.servicepedidos.IServicePedidos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class ControladorPedidos {

    @Autowired
    private IServicePedidos	servicePedido;

    @PostMapping("/guardarPedidos")
    public ResponseEntity<?> guardarPedidos(@RequestBody List<DtoPedidos> pedidosSeleccionados) {

        try{
            servicePedido.guardarPedidos(pedidosSeleccionados);
            return ResponseEntity.ok(HttpStatus.OK);

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar los datos del pedido" + e.getMessage());
        }
    }
}
