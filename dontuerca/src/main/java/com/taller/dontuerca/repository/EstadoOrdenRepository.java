// EstadoOrdenRepository.java
package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.EstadoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoOrdenRepository extends JpaRepository<EstadoOrden, Integer> {
}