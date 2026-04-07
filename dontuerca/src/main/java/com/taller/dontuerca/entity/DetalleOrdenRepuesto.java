package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data @Entity @Table(name = "detalles_orden_repuesto")
public class DetalleOrdenRepuesto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idDetalle;
    @NotNull @ManyToOne @JoinColumn(name = "id_orden", nullable = false) private OrdenServicio ordenServicio;
    @NotNull @ManyToOne @JoinColumn(name = "id_repuesto", nullable = false) private Repuesto repuesto;
    @NotNull @Column(nullable = false) private Integer cantidad;
    @NotNull @Column(nullable = false) private BigDecimal precioCobrado;
}