package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.EstadoFactura;
import com.taller.dontuerca.repository.EstadoFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoFacturaService {
    @Autowired
    private EstadoFacturaRepository estadoFacturaRepository;

    public List<EstadoFactura> obtenerTodos() {
        return estadoFacturaRepository.findAll();
    }

    public EstadoFactura crearEstado(EstadoFactura estado) {
        return estadoFacturaRepository.save(estado);
    }
}