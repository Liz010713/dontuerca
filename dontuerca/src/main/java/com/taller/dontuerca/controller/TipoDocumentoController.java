package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.TipoDocumento;
import com.taller.dontuerca.service.TipoDocumentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-documento")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumento> obtenerTodos() {
        return tipoDocumentoService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> crearTipo(@Valid @RequestBody TipoDocumento tipo) {
        return new ResponseEntity<>(tipoDocumentoService.crearTipoDocumento(tipo), HttpStatus.CREATED);
    }
}