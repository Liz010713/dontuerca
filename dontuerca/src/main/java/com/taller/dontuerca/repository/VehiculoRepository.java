// VehiculoRepository.java
package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}