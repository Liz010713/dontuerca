package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.DetalleOrdenRepuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenRepuesto, Integer> {
}