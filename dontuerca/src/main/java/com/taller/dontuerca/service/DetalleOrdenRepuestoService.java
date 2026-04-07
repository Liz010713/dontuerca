package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.DetalleOrdenRepuesto;
import com.taller.dontuerca.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleOrdenRepuestoService {
    @Autowired
    private DetalleOrdenRepository detalleRepository;

    public List<DetalleOrdenRepuesto> obtenerTodos() {
        return detalleRepository.findAll();
    }

    public DetalleOrdenRepuesto agregarDetalle(DetalleOrdenRepuesto detalle) {
        return detalleRepository.save(detalle);
    }

    public void eliminarDetalle(Integer id) {
        if (!detalleRepository.existsById(id))
            throw new RuntimeException("Detalle no encontrado");
        detalleRepository.deleteById(id);
    }
}