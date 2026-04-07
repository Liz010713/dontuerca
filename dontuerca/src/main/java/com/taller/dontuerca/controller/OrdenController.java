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

    @PutMapping("/{id}/entregar")
    public ResponseEntity<String> entregarVehiculo(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(tallerService.entregarVehiculo(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}