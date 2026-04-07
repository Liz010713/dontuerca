package com.taller.dontuerca.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ReporteFinanzasDTO {
    private Long cantidadFacturasGeneradas; // Cantidad de registros
    private BigDecimal totalIngresosPagados;
    private BigDecimal promedioValorPorFactura; // Promedios de información
}