package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Integer> {
    @Query("SELECT COUNT(o) FROM OrdenServicio o WHERE o.mecanico.idMecanico = :idMecanico")
    Long countOrdenesByMecanico(@Param("idMecanico") Integer idMecanico);
}