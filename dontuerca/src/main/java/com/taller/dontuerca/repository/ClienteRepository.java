package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Spring crea la consulta automáticamente por el nombre del método
    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}