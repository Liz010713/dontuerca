package com.taller.dontuerca.dto;

import lombok.Data;

@Data
public class ReporteInventarioDTO {
    private Long totalTiposRepuestos;
    private Long repuestosEnAlertaCritica; // Repuestos que están a punto de agotarse
}