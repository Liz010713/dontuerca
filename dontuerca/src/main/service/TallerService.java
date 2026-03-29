package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Factura;
import com.taller.dontuerca.entity.OrdenServicio;
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
        // 1. Buscamos la orden
        OrdenServicio orden = ordenRepo.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        // 2. Buscamos la factura asociada a esa orden
        Factura factura = facturaRepo.findByOrdenServicio_IdOrden(idOrden);

        if (factura == null) {
            throw new RuntimeException("No se ha generado factura para esta orden.");
        }

        // 3. REGLA DE NEGOCIO DEL PROFESOR: Verificar estado de factura (2 = PAGADA en
        // nuestra BD)
        if (factura.getIdEstadoFactura() != 2) {
            throw new RuntimeException("¡ALERTA! No se puede entregar el vehículo. La factura está PENDIENTE de pago.");
        }

        // 4. Si todo está pagado, actualizamos el estado de la orden (3 = ENTREGADO)
        orden.setIdEstadoOrden(3);
        ordenRepo.save(orden);

        return "Vehículo entregado con éxito. Cliente al día.";
    }
}