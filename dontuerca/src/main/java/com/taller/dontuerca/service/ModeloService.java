package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Modelo;
import com.taller.dontuerca.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> obtenerTodos() {
        return modeloRepository.findAll();
    }

    public Modelo crearModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }
}