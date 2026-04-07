package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Marca;
import com.taller.dontuerca.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> obtenerTodas() {
        return marcaService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Marca> crearMarca(@Valid @RequestBody Marca marca) {
        return new ResponseEntity<>(marcaService.crearMarca(marca), HttpStatus.CREATED);
    }
}