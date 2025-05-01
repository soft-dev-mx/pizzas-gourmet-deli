package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerpedidos;

import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtopedidos.DtoPedidos;
import com.ampeliodev.pizzasgourmetdeliapirest.service.servicepedidos.IServicePedidos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://pizzasgourmetdeli.com")
public class ControladorPedidos {

    @Autowired
    private IServicePedidos	iServicePedidos;

    @PostMapping("/guardarPedidos")
    public ResponseEntity<?> guardarPedidos(@RequestBody DtoPedidos dtoPedidos) {

        try{
            DtoPedidos dtoPedidosGuardado = iServicePedidos.guardarPedidos(dtoPedidos);

            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar los datos del pedido" + e.getMessage());
        }
    }
}
