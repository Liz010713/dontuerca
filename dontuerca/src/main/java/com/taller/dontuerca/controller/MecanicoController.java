package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Mecanico;
import com.taller.dontuerca.repository.MecanicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mecanicos")
public class MecanicoController {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @GetMapping
    public List<Mecanico> obtenerTodos() {
        return mecanicoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Mecanico> crearMecanico(@Valid @RequestBody Mecanico mecanico) {
        return new ResponseEntity<>(mecanicoRepository.save(mecanico), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMecanico(@PathVariable Integer id) {
        if (!mecanicoRepository.existsById(id))
            return ResponseEntity.notFound().build();
        mecanicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}