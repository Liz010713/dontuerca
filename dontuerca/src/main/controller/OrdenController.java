package com.taller.dontuerca.controller;

import com.taller.dontuerca.service.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private TallerService tallerService;

    // Endpoint para probar la regla del profesor en Swagger
    @PutMapping("/{id}/entregar")
    public ResponseEntity<String> entregarVehiculo(@PathVariable Integer id) {
        try {
            String mensaje = tallerService.entregarVehiculo(id);
            return ResponseEntity.ok(mensaje);
        } catch (RuntimeException e) {
            // Retorna un error 400 Bad Request si la factura no está pagada
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}