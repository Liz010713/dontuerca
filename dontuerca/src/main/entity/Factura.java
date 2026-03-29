package com.taller.dontuerca.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(name = "fecha_emision", insertable = false, updatable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "total_mano_obra", nullable = false)
    private BigDecimal totalManoObra;

    @Column(name = "total_repuestos", nullable = false)
    private BigDecimal totalRepuestos;

    @Column(name = "gran_total", insertable = false, updatable = false)
    private BigDecimal granTotal;

    @OneToOne
    @JoinColumn(name = "id_orden", nullable = false, unique = true)
    private OrdenServicio ordenServicio;

    // Relación al estado de la factura (1=PENDIENTE, 2=PAGADA)
    @Column(name = "id_estado_factura")
    private Integer idEstadoFactura;
}