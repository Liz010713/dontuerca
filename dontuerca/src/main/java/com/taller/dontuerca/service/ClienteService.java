package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.Cliente;
import com.taller.dontuerca.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente crearCliente(Cliente nuevoCliente) {
        try {
            return clienteRepository.save(nuevoCliente);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error de Negocio: Ya existe un cliente registrado con el documento: "
                    + nuevoCliente.getNumeroDocumento());
        }
    }

    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Cliente no encontrado");
        cliente.setIdCliente(id);
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Cliente no encontrado");
        clienteRepository.deleteById(id);
    }
}