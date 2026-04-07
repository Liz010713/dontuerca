package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.EstadoOrden;
import com.taller.dontuerca.repository.EstadoOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoOrdenService {
    @Autowired
    private EstadoOrdenRepository estadoOrdenRepository;

    public List<EstadoOrden> obtenerTodos() {
        return estadoOrdenRepository.findAll();
    }

    public EstadoOrden crearEstado(EstadoOrden estado) {
        return estadoOrdenRepository.save(estado);
    }
}