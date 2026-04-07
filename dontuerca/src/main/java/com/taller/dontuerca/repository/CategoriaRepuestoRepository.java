package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.CategoriaRepuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepuestoRepository extends JpaRepository<CategoriaRepuesto, Integer> {
}