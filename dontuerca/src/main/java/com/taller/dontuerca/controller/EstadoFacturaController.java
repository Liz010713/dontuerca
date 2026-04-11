package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.EstadoFactura;
import com.taller.dontuerca.service.EstadoFacturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estados-factura")
public class EstadoFacturaController {

    @Autowired
    private EstadoFacturaService estadoFacturaService;

    @GetMapping
    public List<EstadoFactura> obtenerTodos() {
        return estadoFacturaService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<EstadoFactura> crearEstado(@Valid @RequestBody EstadoFactura estado) {
        return new ResponseEntity<>(estadoFacturaService.crearEstado(estado), HttpStatus.CREATED);
    }
}