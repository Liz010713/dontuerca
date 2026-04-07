package com.taller.dontuerca.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ReporteTallerDTO {
    private Long cantidadTotalFacturas;
    private Long ordenesPorMecanico;
    private BigDecimal ingresosTotalesPagados;
    private BigDecimal promedioValorFactura;
}