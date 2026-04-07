package com.taller.dontuerca.service;

import com.taller.dontuerca.dto.*;
import com.taller.dontuerca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ReporteService {

    @Autowired
    private FacturaRepository facturaRepo;
    @Autowired
    private OrdenServicioRepository ordenRepo;
    @Autowired
    private RepuestoRepository repuestoRepo;

    // REQUERIMIENTO: "Promedios de información y cantidad de registros"
    public ReporteFinanzasDTO generarReporteFinanzas() {
        ReporteFinanzasDTO dto = new ReporteFinanzasDTO();
        dto.setCantidadFacturasGeneradas(facturaRepo.countTotalFacturas());

        BigDecimal ingresos = facturaRepo.sumIngresosTotalesPagados();
        dto.setTotalIngresosPagados(ingresos != null ? ingresos : BigDecimal.ZERO);

        BigDecimal promedio = facturaRepo.avgPromedioFacturas();
        dto.setPromedioValorPorFactura(promedio != null ? promedio : BigDecimal.ZERO);

        return dto;
    }

    // REQUERIMIENTO: "Cantidad de procesos y parámetros"
    public ReporteOperacionDTO generarReporteProcesos(Integer idMecanico) {
        ReporteOperacionDTO dto = new ReporteOperacionDTO();
        dto.setCantidadTotalProcesos(ordenRepo.count());

        if (idMecanico != null) {
            dto.setProcesosDelMecanico(ordenRepo.countOrdenesByMecanico(idMecanico));
            dto.setMensajeAnalisis("Análisis de procesos filtrado para el mecánico ID: " + idMecanico);
        } else {
            dto.setProcesosDelMecanico(0L);
            dto.setMensajeAnalisis("Envíe el parámetro 'idMecanico' para ver el rendimiento individual.");
        }
        return dto;
    }

    // REQUERIMIENTO: "Análisis de datos y parámetros"
    public ReporteInventarioDTO generarReporteInventario(Integer stockMinimo) {
        ReporteInventarioDTO dto = new ReporteInventarioDTO();
        dto.setTotalTiposRepuestos(repuestoRepo.count());

        // Si el usuario manda un parámetro, evaluamos la alerta crítica con ese número.
        // Si no manda nada, por defecto alertamos los repuestos que tengan 5 o menos en
        // stock.
        int alerta = (stockMinimo != null) ? stockMinimo : 5;
        dto.setRepuestosEnAlertaCritica(repuestoRepo.countByStockLessThanEqual(alerta));

        return dto;
    }
}