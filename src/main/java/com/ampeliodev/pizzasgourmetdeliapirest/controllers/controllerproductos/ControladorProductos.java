package com.ampeliodev.pizzasgourmetdeliapirest.controllers.controllerproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductosResponse;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceproductos.IServiceProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/protected/admin")
@Slf4j
@CrossOrigin(origins = "https://www.soft-dev-mx.com")

public class ControladorProductos {

    @Autowired
    private IServiceProductos interfazServicioProductos;

    @PostMapping("/products/guardarproductospizzas")
    public ResponseEntity<?> guardarProductoPizza(@ModelAttribute DtoEntidadProductos dtoProductos,
                                             @RequestPart("imagenProducto") MultipartFile imagenProducto) {
        try{

            log.info("El nombre del archivo recibido es: " +imagenProducto.getOriginalFilename());

            DtoEntidadProductos dtoProductoGuardado = interfazServicioProductos.guardarProductosPizza(dtoProductos, imagenProducto);
            return ResponseEntity.ok(dtoProductoGuardado);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @PostMapping("/products/guardarproductosotros")
    public ResponseEntity<?> guardarProductoOtros(@ModelAttribute DtoEntidadProductos dtoProductos,
                                             @RequestPart("imagenProducto") MultipartFile imagenProducto) {
        try{

            log.info("El nombre del archivo recibido es: " +imagenProducto.getOriginalFilename());

            DtoEntidadProductos dtoProductoGuardado = interfazServicioProductos.guardarProductosOtros(dtoProductos, imagenProducto);

            return ResponseEntity.ok(dtoProductoGuardado);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/auth/listarProductos")
    public ResponseEntity<?> listarProductos() {
        try {

            List<DtoEntidadProductosResponse> productoDto = interfazServicioProductos.listarProductos();
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/auth/listarProductos/{categoriaProducto1}/{categoriaProducto2}")
    public ResponseEntity<?> listarProductos(@PathVariable String categoriaProducto1,
                                             @PathVariable String categoriaProducto2) {
        try {

            List<DtoEntidadProductosResponse> productoDto = interfazServicioProductos.listarProductosCategoria(categoriaProducto1, categoriaProducto2);
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/auth/listarProductos/{categoriaProducto1}")
    public ResponseEntity<?> listarProductos(@PathVariable String categoriaProducto1){
        try {
            List<DtoEntidadProductosResponse> productoDto = interfazServicioProductos.listarProductosPorUnaCategoria(categoriaProducto1);
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }
}
