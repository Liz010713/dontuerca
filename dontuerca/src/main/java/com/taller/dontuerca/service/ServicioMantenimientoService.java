package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Servicio;
import com.taller.dontuerca.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioMantenimientoService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerTodos() {
        return servicioRepository.findAll();
    }

    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Integer id) {
        if (!servicioRepository.existsById(id))
            throw new RuntimeException("Servicio no encontrado");
        servicioRepository.deleteById(id);
    }
}