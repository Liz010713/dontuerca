package com.taller.dontuerca.service;

import com.taller.dontuerca.dto.ReporteTallerDTO;
import com.taller.dontuerca.repository.FacturaRepository;
import com.taller.dontuerca.repository.OrdenServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ReporteService {

    @Autowired
    private FacturaRepository facturaRepo;
    @Autowired
    private OrdenServicioRepository ordenRepo;

    public ReporteTallerDTO generarReporteGeneral(Integer idMecanico) {
        ReporteTallerDTO reporte = new ReporteTallerDTO();
        reporte.setCantidadTotalFacturas(facturaRepo.countTotalFacturas());

        BigDecimal ingresos = facturaRepo.sumIngresosTotalesPagados();
        reporte.setIngresosTotalesPagados(ingresos != null ? ingresos : BigDecimal.ZERO);

        BigDecimal promedio = facturaRepo.avgPromedioFacturas();
        reporte.setPromedioValorFactura(promedio != null ? promedio : BigDecimal.ZERO);

        if (idMecanico != null) {
            reporte.setOrdenesPorMecanico(ordenRepo.countOrdenesByMecanico(idMecanico));
        } else {
            reporte.setOrdenesPorMecanico(0L);
        }

        return reporte;
    }
}