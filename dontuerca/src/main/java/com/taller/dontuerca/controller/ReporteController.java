package com.taller.dontuerca.controller;

import com.taller.dontuerca.dto.ReporteTallerDTO;
import com.taller.dontuerca.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/general")
    public ResponseEntity<ReporteTallerDTO> obtenerReporteTaller(@RequestParam(required = false) Integer idMecanico) {
        return ResponseEntity.ok(reporteService.generarReporteGeneral(idMecanico));
    }
}