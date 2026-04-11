package com.taller.dontuerca.controller;

import com.taller.dontuerca.entity.Cliente;
import com.taller.dontuerca.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping // El @Valid ejecuta las validaciones de los Models (@NotNull, @NotBlank)
    public ResponseEntity<?> crearCliente(@Valid @RequestBody Cliente nuevoCliente) {
        try {
            return new ResponseEntity<>(clienteRepository.save(nuevoCliente), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // EXCEPCIÓN DEL NEGOCIO (No más de 2 clientes con misma cédula/UNIQUE)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de Negocio: Ya existe un cliente registrado con la cédula/documento: "
                            + nuevoCliente.getNumeroDocumento());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setIdCliente(id);
        try {
            return ResponseEntity.ok(clienteRepository.save(cliente));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de Negocio: Ya existe un cliente registrado con ese documento.");
        }
    }

    @GetMapping("/documento/{doc}")
    public ResponseEntity<?> obtenerPorDocumento(@PathVariable String doc) {
        return clienteRepository.findByNumeroDocumento(doc)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id) {
        if (!clienteRepository.existsById(id))
            return ResponseEntity.notFound().build();
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}