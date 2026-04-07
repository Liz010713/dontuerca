package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Marca;
import com.taller.dontuerca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> obtenerTodos() {
        return marcaRepository.findAll();
    }

    public Marca crearMarca(Marca marca) {
        return marcaRepository.save(marca);
    }
}