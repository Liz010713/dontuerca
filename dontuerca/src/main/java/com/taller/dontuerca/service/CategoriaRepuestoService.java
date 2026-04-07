package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.CategoriaRepuesto;
import com.taller.dontuerca.repository.CategoriaRepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaRepuestoService {
    @Autowired
    private CategoriaRepuestoRepository categoriaRepository;

    public List<CategoriaRepuesto> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    public CategoriaRepuesto crearCategoria(CategoriaRepuesto categoria) {
        return categoriaRepository.save(categoria);
    }
}