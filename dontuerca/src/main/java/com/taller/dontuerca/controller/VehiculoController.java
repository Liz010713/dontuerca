package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Vehiculo;
import com.taller.dontuerca.repository.VehiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
        return new ResponseEntity<>(vehiculoRepository.save(vehiculo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Integer id,
            @Valid @RequestBody Vehiculo vehiculo) {
        if (!vehiculoRepository.existsById(id))
            return ResponseEntity.notFound().build();
        vehiculo.setIdVehiculo(id);
        return ResponseEntity.ok(vehiculoRepository.save(vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Integer id) {
        if (!vehiculoRepository.existsById(id))
            return ResponseEntity.notFound().build();
        vehiculoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}