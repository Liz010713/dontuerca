package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Repuesto;
import com.taller.dontuerca.repository.RepuestoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @GetMapping
    public List<Repuesto> obtenerTodos() {
        return repuestoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Repuesto> crearRepuesto(@Valid @RequestBody Repuesto repuesto) {
        return new ResponseEntity<>(repuestoRepository.save(repuesto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Repuesto> actualizarRepuesto(@PathVariable Integer id,
            @Valid @RequestBody Repuesto repuesto) {
        if (!repuestoRepository.existsById(id))
            return ResponseEntity.notFound().build();
        repuesto.setIdRepuesto(id);
        return ResponseEntity.ok(repuestoRepository.save(repuesto));
    }
}