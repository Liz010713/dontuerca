package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.CategoriaRepuesto;
import com.taller.dontuerca.service.CategoriaRepuestoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRepuestoController {
    @Autowired
    private CategoriaRepuestoService categoriaService;

    @GetMapping
    public List<CategoriaRepuesto> obtenerTodas() {
        return categoriaService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<CategoriaRepuesto> crearCategoria(@Valid @RequestBody CategoriaRepuesto categoria) {
        return new ResponseEntity<>(categoriaService.crearCategoria(categoria), HttpStatus.CREATED);
    }
}