// RepuestoRepository.java
package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
}