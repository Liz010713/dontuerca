package com.taller.dontuerca.controller;

import com.taller.dontuerca.dto.*;
import com.taller.dontuerca.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/finanzas")
    public ResponseEntity<ReporteFinanzasDTO> reporteFinanzas() {
        return ResponseEntity.ok(reporteService.generarReporteFinanzas());
    }

    @GetMapping("/procesos")
    public ResponseEntity<ReporteOperacionDTO> reporteProcesos(
            // AQUÍ ESTÁ EL TRUCO: Le damos el value explícito
            @RequestParam(value = "idMecanico", required = false) Integer idMecanico) {
        return ResponseEntity.ok(reporteService.generarReporteProcesos(idMecanico));
    }

    @GetMapping("/inventario")
    public ResponseEntity<ReporteInventarioDTO> reporteInventario(
            // AQUÍ TAMBIÉN
            @RequestParam(value = "stockAlerta", required = false) Integer stockAlerta) {
        return ResponseEntity.ok(reporteService.generarReporteInventario(stockAlerta));
    }
}