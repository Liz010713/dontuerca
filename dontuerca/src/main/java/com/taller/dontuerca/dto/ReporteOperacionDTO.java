package com.taller.dontuerca.dto;

import lombok.Data;

@Data
public class ReporteOperacionDTO {
    private Long cantidadTotalProcesos; // Las Órdenes de servicio son los "procesos" del taller
    private Long procesosDelMecanico;
    private String mensajeAnalisis;
}