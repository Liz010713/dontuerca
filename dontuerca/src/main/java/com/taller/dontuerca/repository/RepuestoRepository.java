package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
    // Hace el análisis de datos para saber cuántos repuestos tienen poco stock
    Long countByStockLessThanEqual(Integer stockMinimo);
}