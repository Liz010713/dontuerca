package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Modelo;
import com.taller.dontuerca.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {
    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<Modelo> obtenerTodos() {
        return modeloService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Modelo> crearModelo(@Valid @RequestBody Modelo modelo) {
        return new ResponseEntity<>(modeloService.crearModelo(modelo), HttpStatus.CREATED);
    }
}