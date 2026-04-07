package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Factura;
import com.taller.dontuerca.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaBasicoService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }
}