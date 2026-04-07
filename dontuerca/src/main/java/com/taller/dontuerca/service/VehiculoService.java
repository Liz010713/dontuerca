package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Vehiculo;
import com.taller.dontuerca.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        try {
            return vehiculoRepository.save(vehiculo);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error de Negocio: La placa del vehículo ya está registrada en el taller.");
        }
    }

    public Vehiculo actualizarVehiculo(Integer id, Vehiculo vehiculo) {
        if (!vehiculoRepository.existsById(id))
            throw new RuntimeException("Vehículo no encontrado");
        vehiculo.setIdVehiculo(id);
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminarVehiculo(Integer id) {
        if (!vehiculoRepository.existsById(id))
            throw new RuntimeException("Vehículo no encontrado");
        vehiculoRepository.deleteById(id);
    }
}