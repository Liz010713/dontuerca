package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.OrdenServicio;
import com.taller.dontuerca.repository.OrdenServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdenServicioBasicoService {
    @Autowired
    private OrdenServicioRepository ordenRepository;

    public List<OrdenServicio> obtenerTodas() {
        return ordenRepository.findAll();
    }

    public OrdenServicio crearOrden(OrdenServicio orden) {
        return ordenRepository.save(orden);
    }
}