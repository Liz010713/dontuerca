package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.EstadoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoFacturaRepository extends JpaRepository<EstadoFactura, Integer> {
}