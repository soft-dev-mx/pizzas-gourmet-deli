package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerauth;


import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoauth.*;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductosResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceauth.ServiceSecurity;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceproductos.IServiceProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://pizzasgourmetdeli.com")
@Slf4j
public class ControladorAuth {

    @Autowired
    private ServiceSecurity serviceSecurity;


    @Autowired
    private IServiceProductos interfazServicioProductos;

    @PostMapping("/adminsignin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest registerRequest) {
        return serviceSecurity.registraUsuario(registerRequest);
    }

    @PostMapping("/clientesignin")
    public ResponseEntity<?> registerCliente(@RequestBody RegisterRequest registerRequest) {
        return serviceSecurity.registraUsuario(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        return serviceSecurity.login(loginRequest);
    }

    @GetMapping("/listarProductos")
    public ResponseEntity<?> listarProductos() {
        try {

            List<DtoEntidadProductosResponse> productoDto = interfazServicioProductos.listarProductos();
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/listarProductos/{categoriaProducto1}/{categoriaProducto2}")
    public ResponseEntity<?> listarProductos(@PathVariable String categoriaProducto1,
                                             @PathVariable String categoriaProducto2) {
        try {

            List<DtoEntidadProductosResponse> productoDto = interfazServicioProductos.listarProductosCategoria(categoriaProducto1, categoriaProducto2);
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/listarProductos/{categoriaProducto1}")
    public ResponseEntity<?> listarProductos(@PathVariable String categoriaProducto1){
        try {
            List<DtoEntidadProductosResponse> productoDto = interfazServicioProductos.listarProductosPorUnaCategoria(categoriaProducto1);
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

}






