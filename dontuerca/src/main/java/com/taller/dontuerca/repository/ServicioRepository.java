// ServicioRepository.java
package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}