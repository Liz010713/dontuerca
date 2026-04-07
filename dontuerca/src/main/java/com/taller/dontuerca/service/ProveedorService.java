package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Proveedor;
import com.taller.dontuerca.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {
        if (!proveedorRepository.existsById(id))
            throw new RuntimeException("Proveedor no encontrado");
        proveedorRepository.deleteById(id);
    }
}