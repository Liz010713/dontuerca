package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Repuesto;
import com.taller.dontuerca.repository.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepuestoService {
    @Autowired
    private RepuestoRepository repuestoRepository;

    public List<Repuesto> obtenerTodos() {
        return repuestoRepository.findAll();
    }

    public Repuesto crearRepuesto(Repuesto repuesto) {
        return repuestoRepository.save(repuesto);
    }

    public Repuesto actualizarRepuesto(Integer id, Repuesto repuesto) {
        if (!repuestoRepository.existsById(id))
            throw new RuntimeException("Repuesto no encontrado");
        repuesto.setIdRepuesto(id);
        return repuestoRepository.save(repuesto);
    }

    public void eliminarRepuesto(Integer id) {
        if (!repuestoRepository.existsById(id))
            throw new RuntimeException("Repuesto no encontrado");
        repuestoRepository.deleteById(id);
    }
}