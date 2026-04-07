package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.OrdenServicio;
import com.taller.dontuerca.repository.OrdenServicioRepository;
import com.taller.dontuerca.service.TallerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private TallerService tallerService;

    @Autowired
    private OrdenServicioRepository ordenRepository;

    @GetMapping
    public List<OrdenServicio> obtenerTodas() {
        return ordenRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<OrdenServicio> crearOrden(@Valid @RequestBody OrdenServicio orden) {
        return new ResponseEntity<>(ordenRepository.save(orden), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenServicio> actualizarOrden(@PathVariable Integer id,
            @Valid @RequestBody OrdenServicio orden) {
        if (!ordenRepository.existsById(id))
            return ResponseEntity.notFound().build();
        orden.setIdOrden(id);
        return ResponseEntity.ok(ordenRepository.save(orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Integer id) {
        if (!ordenRepository.existsById(id))
            return ResponseEntity.notFound().build();
        ordenRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // REGLA DE NEGOCIO (EXCEPCIONES)
    @PutMapping("/{id}/entregar")
    public ResponseEntity<String> entregarVehiculo(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(tallerService.entregarVehiculo(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}