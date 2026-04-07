package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @Entity @Table(name = "facturas")
public class Factura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idFactura;
    @Column(name = "fecha_emision", insertable = false, updatable = false) private LocalDateTime fechaEmision;
    @NotNull @Column(nullable = false) private BigDecimal totalManoObra;
    @NotNull @Column(nullable = false) private BigDecimal totalRepuestos;
    @Column(name = "gran_total", insertable = false, updatable = false) private BigDecimal granTotal;
    @NotNull @ManyToOne @JoinColumn(name = "id_estado_factura", nullable = false) private EstadoFactura estadoFactura;
    @NotNull @OneToOne @JoinColumn(name = "id_orden", nullable = false, unique = true) private OrdenServicio ordenServicio;
}