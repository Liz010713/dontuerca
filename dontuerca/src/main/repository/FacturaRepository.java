package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    // Spring adivina la consulta SQL solo con el nombre del método
    Factura findByOrdenServicio_IdOrden(Integer idOrden);
}