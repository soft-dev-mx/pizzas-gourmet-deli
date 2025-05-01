package com.ampeliodev.pizzasgourmetdeliapirest.controllers.clip;

import com.ampeliodev.pizzasgourmetdeliapirest.dto.clip.DtoPagoClip;
import com.ampeliodev.pizzasgourmetdeliapirest.service.serviceclip.ServicioPagoClip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://pizzasgourmetdeli.com")
public class ControladorApiClip {

    @Autowired
    private ServicioPagoClip servicioPagoClip;

    @PostMapping("/clip")
    public String pagarConClip(@RequestBody DtoPagoClip dtoPagoClip) throws Exception {

        log.info("controlador clip");
        String x =  servicioPagoClip.crearOrdenPago(dtoPagoClip);
        log.info("orden pago completo"+ x);
        return x;
    }
}
