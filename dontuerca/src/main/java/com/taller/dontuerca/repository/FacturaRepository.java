package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    Factura findByOrdenServicio_IdOrden(Integer idOrden);

    @Query("SELECT COUNT(f) FROM Factura f")
    Long countTotalFacturas();

    @Query("SELECT SUM(f.granTotal) FROM Factura f WHERE f.estadoFactura.idEstadoFactura = 2")
    BigDecimal sumIngresosTotalesPagados();

    @Query("SELECT AVG(f.granTotal) FROM Factura f")
    BigDecimal avgPromedioFacturas();
}