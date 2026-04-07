package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Mecanico;
import com.taller.dontuerca.repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MecanicoService {
    @Autowired
    private MecanicoRepository mecanicoRepository;

    public List<Mecanico> obtenerTodos() {
        return mecanicoRepository.findAll();
    }

    public Mecanico crearMecanico(Mecanico mecanico) {
        return mecanicoRepository.save(mecanico);
    }

    public void eliminarMecanico(Integer id) {
        if (!mecanicoRepository.existsById(id))
            throw new RuntimeException("Mecánico no encontrado");
        mecanicoRepository.deleteById(id);
    }
}