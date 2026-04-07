package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Servicio;
import com.taller.dontuerca.repository.ServicioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping
    public List<Servicio> obtenerTodos() {
        return servicioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@Valid @RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioRepository.save(servicio), HttpStatus.CREATED);
    }
}