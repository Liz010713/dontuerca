package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Factura;
import com.taller.dontuerca.entity.OrdenServicio;
import com.taller.dontuerca.entity.EstadoOrden;
import com.taller.dontuerca.repository.FacturaRepository;
import com.taller.dontuerca.repository.OrdenServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TallerService {

    @Autowired
    private OrdenServicioRepository ordenRepo;
    @Autowired
    private FacturaRepository facturaRepo;

    public String entregarVehiculo(Integer idOrden) {
        OrdenServicio orden = ordenRepo.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        Factura factura = facturaRepo.findByOrdenServicio_IdOrden(idOrden);

        if (factura == null) {
            throw new RuntimeException("No se ha generado factura para esta orden.");
        }

        // Validación exigida por el negocio (estado 2 = PAGADA)
        if (factura.getEstadoFactura().getIdEstadoFactura() != 2) {
            throw new RuntimeException("¡ALERTA! No se puede entregar el vehículo. La factura está PENDIENTE de pago.");
        }

        EstadoOrden estadoEntregado = new EstadoOrden();
        estadoEntregado.setIdEstadoOrden(15); // ID de 'ENTREGADO' según las inserciones (estado_orden)
        orden.setEstadoOrden(estadoEntregado);
        ordenRepo.save(orden);

        return "Vehículo entregado con éxito. Cliente al día.";
    }
}