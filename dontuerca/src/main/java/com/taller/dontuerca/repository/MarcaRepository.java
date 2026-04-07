// MarcaRepository.java
package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}